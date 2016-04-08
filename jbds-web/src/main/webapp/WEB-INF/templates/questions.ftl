<html>
<head>
</head>
<body>
<h1>Questions</h1>
<a href="/teacher/tests/${testId}/questions/create">Создать вопрос</a>
<#if questions?has_content>
<ul>
    <#list questions as question>
        <li>${question.text}</li>
        <li><img src="${question.image}" alt=""></li>
    </#list>
</ul>
</#if>
</body>
</html>
