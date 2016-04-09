<html>
<body>
<h1>Student groups</h1>

<#if students?has_content>
    <#list students as student>
    ФИО: ${student.fio} <br>
    <a href="/admin/ds_admin_accounts/student/${student.id}">изменить</a>
    </#list>
</#if>

</body>
</html>