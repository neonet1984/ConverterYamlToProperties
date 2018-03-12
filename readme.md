Программа сканирует настраиваемую папку на наличие. yml формат файлов , если файл с соответствующим форматом найден,<br> 
программа конвертирует файл в .properties формат,после чего в случае удачного конвертирования перемещает как исходный<br> 
файл в настраиваемую директорию,  так спрашенный файл в директорию, которую вы укажете в настройках<br>
Для начала вам необходим клонировать репозиторий<br>
Используете команду <b>"git clone https://github.com/neonet1984/ConverterYamlToProperties.git"</b><br>
После того как репозиторий склонирован, откройте проект и соберите jar файл, воспользуйтесь командами майвена<br>
 <b>"clean , install"</b><br>
В папке «target» появятся два jar фала. Скопируйте jar файл с именем «ConverterYamlToProperties.jar»<br> 
 в удобную для вас директорию.На уровне с скопированным jar файлом разместите файл «app.properties».<br>
  Пример файла вы можете взять из проекта по адресу <b>"src/main/resources/app.properties"</b>
Дальше сконфигурируйте <b>app.properties</b><br> 
Описание файла:<br>
<b>directory.source.files</b> - указываеться путь к входному yaml файлу<br>
<b>directory.out.files</b> - укахывается путь по которому должен 
записаться конвертированный yaml файл<br>
<b>directory.notvalid.files</b> - указываеться путь директории, в которую будут 
перемещаться не валдиные файлы<br>
<b>directory.converted.files</b> - указываеться путь в директорию, в которую будут перемещаться, 
сконвертированные файлы<br>
<b>time.out=2000</b> частота с которой будет проверяться директория на наличие в ней yaml файлов</br>

Пример:<br>
directory.source.files=C:\\WorkingDirectory\\filetest\\inputDirectory
directory.out.files=C:\\WorkingDirectory\\filetest\\outputDirectory
directory.notvalid.files=C:\\WorkingDirectory\\filetest\\notValidFiles
directory.converted.files=C:\\WorkingDirectory\\filetest\\directoryConvertedFiles
time.out=2000

Запуск приложения:<br>
Вы можете для удобства создать .bat файл, в файле прописать команду:<br> <b>«java –jar ConverterYamlToProperties.jar»</b>
после чего запустить .bat файл. Либо вы можете открыть командную строку, в том катологе в котором находиться
приложения и ввести команду <b>«java –jar ConverterYamlToProperties.jar»</b> в командной строке. После чего приложение
запуститься 


****
****

The program scans the custom folder for availability. yml file format, if a file with the corresponding format is found, <br>
the program converts the file into a .properties format, then, in case of a successful conversion, moves both the source file
file in a custom directory, so the requested file in the directory you specify in the settings <br>
First you need to clone the repository <br>
Use the <b> "git clone https://github.com/neonet1984/ConverterYamlToProperties.git" </b> <br>
After the repository is bent, open the project and compile the jar file, use the Mayween commands <br>
 <b> "clean, install" </b> <br>
In the folder "target" two jar files will appear. Copy the jar file named "ConverterYamlToProperties.jar" <br>
 in a directory convenient for you. On the level with the copied jar file, place the file "app.properties". <br>
  You can take a sample file from the project at <b> "src / main / resources / app.properties" </b>
Next, configure <b> app.properties </b> <br>
File description: <br>
<b> directory.source.files </b> - indicates the path to the input yaml file <br>
<b> directory.out.files </b> - the path for which the
enroll a converted yaml file <br>
<b> directory.notvalid.files </b> - indicates the path of the directory to which the
move non-valdin files <br>
<b> directory.converted.files </b> - specify the path to the directory to be moved to,
converted files <br>
<b> time.out = 2000 </b> the frequency with which the directory will be checked for the presence of yaml files in it </br>

Example: <br>
directory.source.files = C: \\ WorkingDirectory \\ filetest \\ inputDirectory
directory.out.files = C: \\ WorkingDirectory \\ filetest \\ outputDirectory
directory.notvalid.files = C: \\ WorkingDirectory \\ filetest \\ notValidFiles
directory.converted.files = C: \\ WorkingDirectory \\ filetest \\ directoryConvertedFiles
time.out = 2000

Running the application: <br>
You can create a .bat file for your convenience, set the command in the file: <br> <b> "java -jar ConverterYamlToProperties.jar" </b>
then run the .bat file. Or you can open a command line in the same location
and enter the <b> "java -jar ConverterYamlToProperties.jar" </b> command on the command line. After that, the application
start