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
    else if (this.endpoint.type === EndpointType.GET && this.endpoint.value === '/operator/regions') {
      let first = true;
      for (const area of json ) {
        this.addRegion(JSON.stringify(area.serviceArea.points), first);
        first = false;
      }
    }
  }

  private showSimpleLeg(result: any) {
    const start = this.toCoord(result.leg.from);
    const end = this.toCoord(result.leg.to);
    this.addLine(start, end);
    const lng = (result.leg.from.lng + result.leg.to.lng) / 2;
    const lat = (result.leg.from.lat + result.leg.to.lat) / 2;
    this.addIcon(result.typeOfAsset, '[' + lat + ',' + lng + ']', result.operatorDescription);
  }

  private showSegments(json: any) {
    if (json.results.length > 0) {
      for (const marker of this.modalityMarkers) {
        marker.removeFrom(this.map);
      }

      for ( const segment of this.segments ) {
        segment.removeFrom(this.map);
      }
      this.segments = [];

      for (const result of json.results) {
        if (result.resultType === 'simpleLeg') {
          this.showSimpleLeg(result);
        }
        else if (result.resultType === 'compositeLeg') {
          for ( const operatorLeg of result.legs ) {
            this.showSimpleLeg(operatorLeg);
          }
          return;
        }
      }
    }
  }

  private showRegions(json: any) {
    if (json.conditions !== null ) {
      if (json.conditions.length > 0) {
        let first = true;
        for (const condition of json.conditions) {
          if (condition.conditionType === 'conditionReturnArea') {
            this.addRegion(JSON.stringify(condition.returnArea.points), first);
            first = false;
          }
        }
      }
    }
  }

  private toCoord(point: any) {
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
}
