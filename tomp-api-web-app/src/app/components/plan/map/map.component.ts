import { Component, AfterViewInit, Input } from '@angular/core';
import * as L from 'leaflet';
import 'leaflet-defaulticon-compatibility';
import { latLng, Map, tileLayer, LeafletMouseEvent } from 'leaflet';
import { PlanningOptions } from '../../../domain/planning-options.model';
// import 'leaflet/dist/images/marker-shadow.png';
import { Coordinates } from '../../../domain/coordinates.model';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements AfterViewInit {

  @Input() planning: PlanningOptions;
  locationsLayer: L.GeoJSON;
  locations: GeoJSON.Point[] = [];

  regionLayer: L.GeoJSON;

  private map: Map;

  constructor() { }

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
      this.addRegion(content);
    };
  }

  public addRegion(e: string) {
    if ( this.regionLayer != null ) {
      this.regionLayer.clearLayers();
    }
    const e1 = e.replace(/[\n\r]/g, '');
    const e2 = e1.replace(/[' ']/g, '');
    const e3 = e2.replace(/["lng":]/g, '');
    const e4 = e3.replace(/["lat":]/g, '');
    const e5 = e4.replace(/[{]/g, '[');
    const e6 = e5.replace(/[}/]/g, ']');
    const geojson = JSON.parse( '[{"type":"Polygon", "coordinates":[' + e6 + ']}]');
    this.regionLayer = L.geoJSON(geojson).addTo(this.map);
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

}
