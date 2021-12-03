$configFiles = Get-ChildItem ./swagger_server/models/. *.py -rec
foreach ($file in $configFiles)
{
    (Get-Content $file.PSPath) |
    Foreach-Object { $_ -replace "Object", "any" } |
    Set-Content $file.PSPath
}

$configFiles = Get-ChildItem ./swagger_server/swagger/. *.yaml -rec
foreach ($file in $configFiles)
{
    (Get-Content $file.PSPath) |
    Foreach-Object { $_ -replace "\[optional\]", "optional_" } |
    Set-Content $file.PSPath
}

