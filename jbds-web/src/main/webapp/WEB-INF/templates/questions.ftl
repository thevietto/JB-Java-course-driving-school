<html>
<head>
</head>
<body>
<h1>Questions</h1>
<a href="/teacher/tests/${testId}/questions/create">Создать вопрос</a>
<#if questions?has_content>
<ul>
    <#list questions as question>
        <li><a href="/teacher/tests/${testId}/questions/${question.id}">${question.text}</a></li>
    </#list>
</ul>
</#if>
</body>
</html>
