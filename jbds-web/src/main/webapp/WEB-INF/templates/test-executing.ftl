<form method="post" action="/student/tasks/${task.id}">
    <#list questions as question>
        <img src="${question.image}"><br>
        <h4>${question.text}</h4>
        <#list answers[question.id?string] as answer>
            <input type="radio" name="${question.id}" value="${answer.id}"> ${answer.text}<br/>
        </#list><br/><br/>
    </#list>
    <input type="submit" value="Отправить">
</form>