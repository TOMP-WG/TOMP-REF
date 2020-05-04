import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RequestComponent } from './components/request/request.component';
import { ResponseComponent } from './components/response/response.component';
import { MapComponent } from './components/plan/map/map.component';
import { PlanComponent } from './components/plan/plan.component';

@NgModule({
  declarations: [
    AppComponent,
    RequestComponent,
    ResponseComponent,
    MapComponent,
    PlanComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
