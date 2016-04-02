<html>
<head>
    <title>student</title>
</head>
<body>
<h1>Create test</h1>
<h3>Название теста</h3>
<form action="/teacher/test/${testId}/questions/create" method="post">
    <input type="text" name="text" placeholder="Вопрос"><br>
    <input type="file" name="text" placeholder="Изображение"><br>
    <select name="category">
    <#list categories as category>
        <option value="${category.id}">${category.name}</option>
    </#list>
    </select>
    <br>
    Варианты ответа <br>
    <ul>
        <li><input type="text" name="answer"> <input type="radio" name="isTrue"></li>
        <li><input type="text" name="answer"> <input type="radio" name="isTrue"></li>
        <li><input type="text" name="answer"> <input type="radio" name="isTrue"></li>
        <li><input type="text" name="answer"> <input type="radio" name="isTrue"></li>
    </ul>
</form>
</body>
</html>
