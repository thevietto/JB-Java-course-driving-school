<html>

<body>
<h1>добавление потока студентов</h1>
<form action="/admin/student_groups" method="post" enctype="multipart/form-data">
    <label>Фио преподавателя</label><input name="teacher"><br/>
    <p>/////// В бичах есть только Сидорова Марья Ивановна  из автошколы с id=1 /////</p>
    File to upload: <input type="file" name="file"><br/>

    <input type="submit" value="Upload">
    Press here to upload the file!
</form>
<div>Испльзуйте файлы формата .xls</div>
<br/>
<div>Студенты в файле должны быть в виде "Фамилия | Имя | Отчество" без пропусков строк</div>
</form>
</body>
</html>