<html>
<body>
<h1>Student groups</h1>
<#if groups?has_content>
    <#list groups as group>
    <a href="/teacher/student_groups/${group.id}">${group.id}</a><br/>
    <br/>
    </#list>
</#if>
</body>
</html>