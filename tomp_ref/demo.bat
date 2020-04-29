xcopy /Y /Q ".\src\main\resources\application.yml" ".\target"
xcopy /Y /Q ".\src\main\resources\*.json" ".\target"
xcopy /Y /Q "..\tomp_meta\src\main\resources\*.json" "..\tomp_meta\target"

start cmd /K start.bat bike
start cmd /K start.bat car
start cmd /K startMeta.bat
start cmd /K start.bat maasprovider
