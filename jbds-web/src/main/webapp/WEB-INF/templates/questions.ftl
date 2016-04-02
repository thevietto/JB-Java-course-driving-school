<html>
<head>
</head>
<body>
<h1>Questions</h1>
<a href="/teacher/test/${testId}/questions/create">Создать вопрос</a>
<#if questions?has_content>
<ul>
    <#list questions as questin>
        <li>${question.text}</li>
    </#list>
</ul>
</#if>
</body>
</html>
