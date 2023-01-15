# Get the script directory
$dir = $(Split-Path -Parent $MyInvocation.MyCommand.Definition) + "\img"
$files = Get-ChildItem $dir -File
$index = $(Split-Path -Parent $MyInvocation.MyCommand.Definition) + "\index.txt"
if (Test-Path $index) {
    Remove-Item $index
}
New-Item $index -ItemType File
foreach ($file in $files) {
    $name = $file.Name
    $size = $file.Length
    $date = $file.LastWriteTime
    $line = "$name $size $date"
    Add-Content $index $line
}
