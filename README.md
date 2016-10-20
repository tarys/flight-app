# Flight-app
Sample app for flight services:

- `http://<server>:<port>/tickets/{ticketId}` - tickets availabiliy check service. `ticketId` should be numeric value
- `http://<server>:<port>/baggage` - baggage service
- `http://<server>:<port>/coupons` - coupons service
- `http://<server>:<port>/health` - app health state
- `http://<server>:<port>/env` - app details

## Build process
`$ mvnw package`

## Running
`$ java -jar flight-app-0.0.1-SNAPSHOT.jar`

## Logs
`flight-app.log` resides in the same folder as  `flight-app-0.0.1-SNAPSHOT.jar`
