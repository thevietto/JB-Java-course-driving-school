<html>
<body>
<h1>Профиль студента</h1>

<form action="/admin/ds_admin_accounts/student/${student.id}" method="post">
    ФИО <input type="text" name="fio" value="${student.fio}"><br/>
    НВЫЙ ПАРОЛЬ<input type="text" name="password" value=""/><br/>
    <input type="submit" value="Сохранить">
</form>
<form action="/admin/ds_admin_accounts/student/${student.id}" method="post">
    <input type="submit" value="Удалить студента">
</form>

</body>
</html>