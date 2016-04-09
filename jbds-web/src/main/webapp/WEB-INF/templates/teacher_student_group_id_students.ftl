<html>
<body>
<h1>Student group</h1>
<#if students?has_content>
    <#list students as student>
    <a href="/teacher/student_groups/${student.studentGroup.id}/students/${student.id}">${student.fio}</a>
    <br/>
    </#list>
</#if>
</body>
</html>