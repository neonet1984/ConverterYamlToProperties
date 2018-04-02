start maven
:time
TIMEOUT /T 12
cd ../
cd target
    if not exist ConverterYamlToProperties.jar goto time
cd ../../
mkdir app
cd ConverterYamlToProperties/target
copy ConverterYamlToProperties.jar ..\..\app\
copy ..\bin\startup.bat ..\..\app
copy ..\bin\app.properties ..\..\app
