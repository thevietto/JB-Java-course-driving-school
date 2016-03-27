<%--
  Created by IntelliJ IDEA.
  User: mikl
  Date: 27.03.2016
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="ch" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<body>
<h1>Профиль студента</h1>

<form action="/admin/ds_admin_accounts/save_student_account/" method="post">
    <input type="hidden" name="id" value='<ch:out value='${student.id}'/>'>
    ФИО <input type="text" name="fio" value="<ch:out value='${student.fio}'/>"><br/>
    ЛОГИН <input type="text" name="login" value="<ch:out value='${student.credentials.login}'/>"/><br/>
    НВЫЙ ПАРОЛЬ<input type="text" name="password" value=""/><br/>
    <input type="submit" value="Сохранить"><a href="/admin/ds_admin_accounts/<ch:out value='${student.id}'/>/delete_student_account">Удалить студента</a>
</form>


</body>
</html>