@echo off
setlocal enabledelayedexpansion

set content=
for /f "delims=" %%i in ('type %2') do set content=!content! %%i

SET _result=%content:"=\"%

curl -s -H "Content-Type: application/json" -H "Accept-Language: NL" -H "Api: TOMP" -H "maas-id: %MaaSId%" -H "Api-Version: %ApiVersion%" -H "Accept: application/json" ^
    -d "%_result%" ^
    -X POST %1