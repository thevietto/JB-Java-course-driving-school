<html>
<body>
<h1>Student groups</h1>

<#if groups?has_content>
    <#list groups as group>
    Номер: ${group.id} <br>
    Преподаватель: ${group.teacher.fio} <br>
    <a href="/admin/student_group/${group.id}/students">Посмотреть учеников группы</a>
    </#list>
</#if>

</body>
</html>