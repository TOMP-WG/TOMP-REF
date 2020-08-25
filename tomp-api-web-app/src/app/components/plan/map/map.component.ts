import { Component, AfterViewInit, Input } from '@angular/core';
import * as L from 'leaflet';
import 'leaflet-defaulticon-compatibility';
import { latLng, Map, tileLayer, LeafletMouseEvent } from 'leaflet';
import { PlanningOptions } from '../../../domain/planning-options.model';
import { InternalService } from '../../../services/internal.service';
// import 'leaflet/dist/images/marker-shadow.png';
import { Coordinates } from '../../../domain/coordinates.model';
import { ThrowStmt } from '@angular/compiler';
import { Endpoint } from 'src/app/domain/endpoint.model';
import { EndpointType } from 'src/app/domain/endpoint.enum';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements AfterViewInit {

  @Input() planning: PlanningOptions;
  locationsLayer: L.GeoJSON;
  locations: GeoJSON.Point[] = [];

  regions: Array<L.GeoJSON> = [];
  segments: Array<L.GeoJSON> = [];
  modalityMarkers: Array<L.Marker> = [];

  resultIndex = 0;
  cachedResult = '';
  nextDisabled = true;
  previousDisabled = true;

  endpoint: Endpoint;
  private map: Map;

  constructor(public internalService: InternalService) {
    this.internalService.onAddResponse().subscribe(response => this.fetchAreas(response));
    this.internalService.onEndPointChanged().subscribe(e => this.endpoint = e);
  }

  ngAfterViewInit(): void {
    this.initMap();
  }

  private initMap(): void {
    this.map = new Map('map', {
      center: latLng(51.528833, 3.759161),
      zoom: 6
    });

    const tiles = tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 19,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    tiles.addTo(this.map);

    this.locationsLayer = L.geoJSON().addTo(this.map);
    this.map.on('click', this.onMapClick, this);

    const container = document.getElementById('map');
    container.ondragover = (event) => {
      event.preventDefault();
    };
    container.ondrop = (event) => {
      const content = event.dataTransfer.getData('Text');
      this.addRegion(content, true);
    };
  }

  public addRegion(e: string, clear: boolean) {
    if ( clear ) {
      for ( const region of this.regions ) {
        region.removeFrom(this.map);
      }
      this.regions = [];
    }
    const e1 = e.replace(/[\n\r]/g, '');
    const e2 = e1.replace(/[' ']/g, '');
    const e3 = e2.replace(/["lng":]/g, '');
    const e4 = e3.replace(/["lat":]/g, '');
    const e5 = e4.replace(/[{]/g, '[');
    const e6 = e5.replace(/[}/]/g, ']');
    const geojson = JSON.parse( '[{"type":"Polygon", "coordinates":[' + e6 + ']}]');
    const regionOnMap = L.geoJSON(geojson);
    regionOnMap.addTo(this.map);
    this.regions.push(regionOnMap);
  }

  private onMapClick(e: LeafletMouseEvent) {
    const location = L.GeoJSON.latLngToCoords(e.latlng);
    const point = {
      type: 'Point',
      coordinates: location
    } as GeoJSON.Point;
    if (this.locations.length === 2) {
      this.locations.shift();
    }
    this.locations.push(point);
    this.locationsLayer.clearLayers();
    this.locations.forEach(loc => this.locationsLayer.addData(loc));
    this.saveCoordinates();
  }

  private saveCoordinates() {
    this.setLngLat(this.planning.from, this.locations[0].coordinates);
    if (this.locations.length > 1) {
      this.setLngLat(this.planning.to, this.locations[1].coordinates);
    }
  }

  private setLngLat(coord: Coordinates, pos: GeoJSON.Position) {
    coord.lng = pos[0];
    coord.lat = pos[1];
  }

  private fetchAreas(json: any) {
    if ( this.endpoint == null ){
      return;
    }
    if ( this.endpoint.type === EndpointType.POST && this.endpoint.value === '/planning-options/') {
      this.showRegions(json);
      this.showSegments(json);
    }
    else if ( this.endpoint.type === EndpointType.POST && this.endpoint.value.startsWith('/plannings/')) {
      this.showRegions(json);
      this.showSegments(json);
    }
    else if (this.endpoint.type === EndpointType.GET && this.endpoint.value === '/operator/regions') {
      let first = true;
      for (const area of json ) {
        if (area.serviceArea !== undefined) {
          this.addRegion(JSON.stringify(area.serviceArea.points), first);
          first = false;
        }
      }
    }
  }

  private showSimpleLeg(result: any) {
    if (result.parts !== undefined) {
      for ( const part of result.parts ) {
        this.showSimpleLeg(part);
      }
    }
    else if (result.legs !== undefined) {
      for ( const part of result.legs ) {
        this.showSimpleLeg(part);
      }
    }
    else
    {
      let ptFrom = result.from.coordinates;
      let ptTo = result.to.coordinates;
      if ( ptFrom === undefined ) {
        ptFrom = result.from;
        ptTo = result.to;
      }
      const start = this.toCoord(ptFrom);
      const end = this.toCoord(ptTo);
      this.addLine(start, end);
      const lng = (ptFrom.lng + ptTo.lng) / 2;
      const lat = (ptFrom.lat + ptTo.lat) / 2;

      let description = '';
      if (result.suboperator !== undefined ) {
        description = result.suboperator.name + ' ' + result.suboperator.description;
      }
      let asset = result.asset;
      if (asset === undefined && result.legs !== undefined)  {
        asset = result.legs[0].assetType;
      }
      if (asset === undefined) {
        asset = result.assetType;
      }
      this.addIcon(asset, '[' + lat + ',' + lng + ']', description);
    }
  }

  private showSimpleLegV05(result: any) {
    const start = this.toCoord(result.leg.from);
    const end = this.toCoord(result.leg.to);
    this.addLine(start, end);
    const lng = (result.leg.from.lng + result.leg.to.lng) / 2;
    const lat = (result.leg.from.lat + result.leg.to.lat) / 2;
    this.addIcon(result.typeOfAsset, '[' + lat + ',' + lng + ']', result.operatorDescription);
  }

  private showSegments(json: any) {
    this.resultIndex = 0;
    for (const marker of this.modalityMarkers) {
      marker.removeFrom(this.map);
    }

    for ( const segment of this.segments ) {
      segment.removeFrom(this.map);
    }
    this.segments = [];

    this.showLinesV05(json);
    this.showLines(json);
  }

  private showLinesV05(json: any) {
    if (json.results) {
      // version 0.5.0
      for (const result of json.results) {
        if (result.resultType === 'simpleLeg') {
          this.showSimpleLegV05(result);
        }
        else if (result.resultType === 'compositeLeg') {
          for ( const operatorLeg of result.legs ) {
            this.showSimpleLegV05(operatorLeg);
          }
          return;
        }
      }
    }
  }

  private showLines(json: any) {
    if (json.legOptions) {
      this.cachedResult = json;
      // version 0.6.0 +
      let i = 0 ;
      for (const result of json.legOptions) {
        if ( i === this.resultIndex ) {
          this.showSimpleLeg(result);
        }
        i++;
      }
    }
    else if (json.options) {
      this.cachedResult = json;
      // version 0.9.0 +
      let i = 0 ;
      for (const result of json.options) {
        if ( i === this.resultIndex ) {
          this.showSimpleLeg(result);
        }
        i++;
      }
    }
  }

  private showRegions(json: any) {
    if (json.conditions !== undefined ) {
      if (json.conditions.length > 0) {
        let first = true;
        for (const condition of json.conditions) {
          if (condition.conditionType === 'conditionReturnArea') {
            if (condition.returnArea !== undefined ) {
              this.addRegion(JSON.stringify(condition.returnArea.points), first);
              first = false;
            }
          }
        }
      }
    }
  }

  private toCoord(point: any) {
    if (point.coordinates){
      return '[' + point.coordinates.lng + ',' + point.coordinates.lat + ']';
    }
    return '[' + point.lng + ',' + point.lat + ']';
  }

  private addLine(start: string, end: string) {
    const geojson = JSON.parse( '[{"type":"LineString", "coordinates":[' + start + ',' + end + ']}]');
    const segmentOnMap = L.geoJSON(geojson);
    segmentOnMap.addTo(this.map);
    this.segments.push(segmentOnMap);
  }

  private addIcon(result: any, coord: any, tt: string) {
    let img = '';
    switch (result.assetClass){
      case 'BICYCLE':
        img = '/assets/bike.png';
        break;
      case 'CAR':
        img = '/assets/car.png';
        break;
      case 'BUS':
        img = '/assets/bus.png';
        break;
      case 'RAIL':
        img = '/assets/train.png';
        break;
      case 'TRAM':
        img = '/assets/tram.png';
        break;
      case 'METRO':
        img = '/assets/metro.png';
        break;
      case 'TAXI':
        img = '/assets/taxi.png';
        break;
      default:
        img = '/assets/foot.png';
        break;
    }
    if ( img !== '' ) {
      const marker = L.icon( { iconUrl : img, iconSize: [40, 40] });
      const icon = L.marker(JSON.parse(coord), { icon: marker } );
      icon.bindTooltip(tt);
      this.modalityMarkers.push(icon);
      icon.addTo(this.map);
    }
  }

  public previousResult(e: Event) {
    for (const marker of this.modalityMarkers) {
      marker.removeFrom(this.map);
    }
    for ( const segment of this.segments ) {
      segment.removeFrom(this.map);
    }
    this.segments = [];
    if (this.resultIndex > 0) {
      this.resultIndex--;
      this.showLines(this.cachedResult);
    }
    e.stopPropagation();
    return false;
  }

  public nextResult(e: Event) {
    for (const marker of this.modalityMarkers) {
      marker.removeFrom(this.map);
    }
    for ( const segment of this.segments ) {
      segment.removeFrom(this.map);
    }
    this.segments = [];
    this.resultIndex++;
    this.showLines(this.cachedResult);
    e.stopPropagation();
    return false;
  }
}
