import { Component, AfterViewInit } from '@angular/core';
import { latLng, Map, tileLayer, LeafletMouseEvent } from 'leaflet';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements AfterViewInit {

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

    this.map.on('click', this.onMapClick);
  }

  private onMapClick(e: LeafletMouseEvent) {
    console.log('You clicked the map at ' + e.latlng.toString());
  }

}
