Конвертатор файлов из yaml в properties
========================================
Программа сканирует настраиваемую папку на наличие. yml формат файлов, если файл с соответствующим форматом найден,
программа конвертирует файл в .properties формат, после чего в случае удачного конвертирования перемещает как исходный
файл в настраиваемую директорию, так спрашенный файл в директорию, которую вы укажете в настройках.
***
Стек технологий:
- Java
- Spring 

Инструменты сборки:
- Maven

На вашей системе должны быть установленны:
1. Java 8
    * По [ссылке](http://barancev.github.io/how-to-install-java-on-windows/), вы можете прочесть информацию по установке
    java , а также получить рекомендации по настройке переменных окружения
2.  Maven 3.3.9
    * Скачать можете по [ссылке](https://archive.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.zip), а инструкцию по
    установке можете прочесть [тут](http://www.apache-maven.ru/install.html)
3.  Git
    * Доступен по [ссылке](https://git-scm.com/downloads)    
    
Сборка проекта
=========================================
1. Для начала вам необходим клонировать репозиторий.
   * Откройте командную строку и введите в нее *git clone https://github.com/neonet1984/ConverterYamlToProperties.git*
2. Теперь необходимо собрать jar файл
   * Воспользуйтесь build.bat файлом который лежит по адрессу *src/main/resources/build.bat*, вынесите этот файл в 
   корень с проектом и запустите его
3. Настройка
   * В папке *target* появятся два jar фала. Скопируйте jar файл с именем *ConverterYamlToProperties.jar*
     в удобную для вас директорию. 
   * На уровне с скопированным jar файлом разместите файлы:  *app.properties* и файл
   *startup.bat*, эти файлы вы можете взять по адрессу *src/main/resources/app.properties* и *src/main/resources/startup.bat*
4. Конфигурирование app.properties
   * Откройте ранее скопированный вами app.properties и установите пути к директориям, и сохраните файл. 
   * Описание app.properties:<br>
   *directory.source.files* - указываеться путь к входному yaml файлу<br>
   *directory.out.files* - укахывается путь по которому должен записаться конвертированный yaml файл<br>
   *directory.error.files* - указываеться путь директории, в которую будут перемещаться не валдиные файлы<br>
   *directory.success.files* - указываеться путь в директорию, в которую будут перемещаться,сконвертированные файлы<br>
   *time.out=2000* - частота с которой будет проверяться директория на наличие в ней yaml файлов</br>
   * Пример app.properties файла:<br>
   directory.source.files=C:\\WorkingDirectory\\filetest\\inputDirectory<br>
   directory.out.files=C:\\WorkingDirectory\\filetest\\outputDirectory<br>
   directory.error.files=C:\\WorkingDirectory\\filetest\\errorDirectory<br>
   directory.success.files=C:\\WorkingDirectory\\filetest\\successDirectory<br>
   time.out=2000<br>

Запуск приложения
==================
Когда произведены все настроки, запустите ранее вами скопированный startup.bat
***

The file converter from yaml in properties
========================================
The program scans the custom folder for availability. yml file format, if a file with the appropriate format is found,
the program converts the file into a .properties format, then in case of a successful conversion it moves as the original
file in a custom directory, so the requested file in the directory you specify in the settings.
***
Stack of technologies:
- Java
- Spring

Build Tools:
- Maven

Your system must have:
1. Java 8
   * By [link](http://barancev.github.io/how-to-install-java-on-windows/), you can read the installation information
     java, as well as get recommendations for setting environment variables
2. Maven 3.3.9
   * You can download by [link](https://archive.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.zip), and the instruction on
    installation can read [here](http://www.apache-maven.ru/install.html)
3. Git
   * Available by [link](https://git-scm.com/downloads)
    
#Build the project

1. First, you need to clone the repository.
   * Open a command prompt and type *git clone https://github.com/neonet1984/ConverterYamlToProperties.git*
2. Now you need to compile the jar file
   * Use the build.bat file which is located at the address *src/main/resources/build.bat*, put this file in the
   root with the project and run it
3. Setting up
   * In the folder *target* two jar files will appear. Copy the jar file named *ConverterYamlToProperties.jar*
     in a directory convenient for you.
   * At the level with the copied jar file, place the files: *app.properties* and the file
   *startup.bat*, these files you can take at the address *src/main/resources/app.properties* and *src/main/resources/startup.bat*
4. Configuring app.properties
   * Open the app.properties you previously copied and set the path to the directories, and save the file.
   * Description of app.properties: <br>
   *directory.source.files* - indicates the path to the input yaml file <br>
   *directory.out.files* - the path to which the converted yaml file should be recorded <br>
   *directory.error.files* - indicates the path of the directory to which non-valdin files will be moved <br>
   *directory.success.files* - indicates the path to the directory to which to move, the converted files <br>
   *time.out = 2000* - the frequency with which the directory will be checked for the presence of yaml files in it <br>
   * Example of app.properties file: <br>
   directory.source.files = C:\\WorkingDirectory\\filetest\\inputDirectory <br>
   directory.out.files = C:\\WorkingDirectory\\filetest\\outputDirectory <br>
   directory.error.files = C:\\WorkingDirectory\\filetest\\errorDirectory <br>
   directory.success.files = C:\\WorkingDirectory\\filetest\\successDirectory <br>
   time.out = 2000 <br>

Running the application
==================
When all the settings are made, run previously copied startup.bat