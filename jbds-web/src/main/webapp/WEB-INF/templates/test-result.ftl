<h1>Результаты теста:</h1><br/>
<#list studentanswers as answer>
    <h4>${answer.question.text}</h4>
    <h5>${answer.answerVariant.id}</h5>
</#list>
<h6>(страница в доработке, пока только id вариантов ответов студента)</h6>
