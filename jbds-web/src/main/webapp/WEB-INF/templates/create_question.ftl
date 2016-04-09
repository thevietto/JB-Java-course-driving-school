<html>
<head>
    <title>student</title>
</head>
<body>
<h1>Create test</h1>
<h3>Название теста</h3>

<h3 style="color: red">
<#if error?has_content>
        ${error}
    </#if>
</h3>
<form action="/teacher/tests/${testId}/questions/create" method="post" enctype="multipart/form-data">
    <input type="text" name="text" placeholder="Вопрос"><br>
    <input type="file" name="multipartFile" placeholder="Изображение"><br>
    <select name="categoryId">
    <#list categories as category>
        <option value="${category.id}">${category.name}</option>
    </#list>
    </select>
    <br>
    Варианты ответа <br>
    <ul>
        <li><input type="text" name="answerVariantForm"> <input type="radio" name="rightAnswer" value="0"></li>
        <li><input type="text" name="answerVariantForm"> <input type="radio" name="rightAnswer" value="1"></li>
        <li><input type="text" name="answerVariantForm"> <input type="radio" name="rightAnswer" value="2"></li>
        <li><input type="text" name="answerVariantForm"> <input type="radio" name="rightAnswer" value="3"></li>
    </ul>
    <input type="submit" value="SUBMIT">
</form>
</body>
</html>
