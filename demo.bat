xcopy /Y /Q ".\src\main\resources\application.yml" ".\target"
xcopy /Y /Q ".\src\main\resources\*.json" ".\target"

start cmd /K start.bat bike
start cmd /K start.bat car
start cmd /K start.bat maasprovider
