Программа конвертирует из yaml фотата, в properties.<br>
Входные и выходные параметры настраиваються в app.properties<br>
Исходный файл должен представлен в .yml формате<br>
Входные параметры :<br>
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
****
****
The program converts from yaml fotata, in properties.<br>
The input and output parameters are configured in app.properties<br>
The source file must be in .yml format<br>
Input parameters:<br>
<b> directory.source.files</b> - indicates the path to the input yaml file <br>
<b> directory.out.files</b> - the path for which the
enroll a converted yaml file<br>
<b> directory.notvalid.files</b> - indicates the path of the directory to which the
move non-valdin files <br>
<b> directory.converted.files</b> - specify the path to the directory to be moved to,
converted files<br>
<b> time.out = 2000</b>the frequency with which the directory will be checked for the presence of yaml files in it </br>