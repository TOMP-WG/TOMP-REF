export class PlanningOptions {

  startTime: number;
  endTime: number;
  from: GeoJSON.Position;
  to: GeoJSON.Position;
  radius = 1000;
  travellers = 1;
  provideIds = false;
  users: [
    {
    age: 44;
    }
  ];
}
