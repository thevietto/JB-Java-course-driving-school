<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Test</title>
    <script src="/resources/js/test-executing.js"></script>
    <script src="/resources/js/jquery-2.1.3.min.js"></script>
</head>
<body>
<div id="js-test-execution">
    <#list questions as question>
        <img src="${question.image}"><br>
        <h4>${question.text}</h4>
            <div class="js-question" id="${question.id}">
            <#list answerVariants[question.id?string] as answerVariant>
                <input type="radio" name="${question.id}" value="${answerVariant.id}"> ${answerVariant.text}<br/>
            </#list><br/><br/>
            </div>
        </#list>
        <span id="js-test-error"></span><br/>
    <button id="js-test-check" onclick="checkTest(${task.id})">Отправить</button>
</div>
</body>
</html>