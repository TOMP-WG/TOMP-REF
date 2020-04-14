rem @echo off
call setheaders.bat 1

rem Call MP and create a random amount of trips
rem -------------------------------------------
call post.bat http://localhost:8090/planning-options/ planning-options-body.json > result.json
rem jq "[.results[] | {id: .id, legs: .legs[] | {id: .id, operator: .\"operator-name\", type: .\"type-of-asset\".\"asset-class\" } }]" result.json | jq "group_by(.id)"
jq "[.results[] | {id: .id, legs: .legs[] | {id: .id, type: .\"type-of-asset\".\"asset-class\" } }]" result.json | jq "group_by(.id)"

rem Evaluate the number of trips created
rem ------------------------------------
FOR /F "tokens=* USEBACKQ" %%F IN (`jq ".[] | length" result.json`) DO (SET nb=%%F)
echo number of different trips %nb%

rem choose one of the trips by user
rem -------------------------------
:choosetrip
CHOICE /C 123 /M "choose a trip"
set /a choice="%ERRORLEVEL%-1"
if %choice% geq %nb% goto choosetrip


rem create bookings
rem ---------------
set q=".results[%choice%].id"
FOR /F "tokens=* USEBACKQ" %%F IN (`jq -r %q% result.json`) DO (
	SET bookingid=%%F
)
echo "choosen %choice% (%bookingid%)"

echo {"id": "%bookingid%", "customer": { "id": "A0-123456", "first-name": "John", "last-name": "Doe", "phone": "yes" }} > booking.json

call post.bat http://localhost:8090/bookings/ booking.json > result2.json

echo booked trip %choice%
jq "{id: .id, state: .state}" result2.json
