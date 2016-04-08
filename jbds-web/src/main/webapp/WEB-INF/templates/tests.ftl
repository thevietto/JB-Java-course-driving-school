<html>
<body>
<h1>Tests</h1>

<#if tests?has_content>
    <#list tests as test>
    <a href="/teacher/tests/${test.id}/questions">${test.description}</a> <br>
    </#list>
</#if>

</body>
</html>