rem @echo off
call setheaders.bat 1
call post.bat http://localhost:8090/planning-options/ planning-options-body.json > result.json
rem jq "[.results[] | {id: .id, legs: .legs[] | {id: .id, operator: .\"operatorName\", type: .\"typeOfAsset\".\"assetClass\" } }]" result.json | jq "group_by(.id)
jq "[.results[] | {id: .id, legs: .legs[] | {id: .id, type: .\"typeOfAsset\".\"assetClass\" } }]" result.json | jq "group_by(.id)

CHOICE /C 123 /M "choose a trip"

set /a choice="%ERRORLEVEL%-1"
set q=".results[%choice%].id"
FOR /F "tokens=* USEBACKQ" %%F IN (`jq -r %q% result.json`) DO (
	SET bookingid=%%F
)
echo "choosen %choice% (%bookingid%)"

echo {"id": "%bookingid%", "customer": { "id": "A0-123456", "firstName": "John", "lastName": "Doe", "phone": "yes" }} > booking.json

call post.bat http://localhost:8090/bookings/ booking.json > result2.json

echo booked trip %choice% 
jq "{id: .id, state: .state}" result2.json