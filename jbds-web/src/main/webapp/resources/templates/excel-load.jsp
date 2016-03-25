<%--
  Created by IntelliJ IDEA.
  User: azat
  Date: 21.03.16
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
                 pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="/admin/add_students/students_file" enctype="multipart/form-data">
    File to upload: <input type="file" name="file"><br />

    <input type="submit" value="Upload">
    Press here to upload the file!
</form>
<div>Испльзуйте файлы формата .xls или .xlsx</div><br/>
<div>Студенты в файле должны быть в виде "Фамилия | Имя | Отчество" без пропусков строк</div>
</body>
</html>
