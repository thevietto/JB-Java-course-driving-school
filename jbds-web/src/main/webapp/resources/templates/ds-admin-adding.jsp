<%--
  Created by IntelliJ IDEA.
  User: aleksandrpliskin
  Date: 18.03.16
  Time: 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/admin/add_students" method="post">
    <p><label>Имя</label><input name="firstname"/></p>
    <p><label>Фамилия</label><input name="surname"/></p>
    <p><label>Отчество</label><input name="lastname"/></p>
    <input type="submit" value="go"/>
</form>
<br/>

<a href="/admin/upload_file">Добавить через excel</a>


<h1>порядок важен!!!</h1>


</body>
</html>
