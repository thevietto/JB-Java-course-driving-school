<h1>${question.question}</h1>
<hr/>
<#list answers as a>
${a.answer} <br/>
by ${a.credential.login}<br/>
<hr/>
</#list>

<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<@sf.form action="${url}/${question.id}/answers" method="post" modelAttribute="answerForm">
    <@sf.input path="answer" id="answer" placeholder="Ответ"/>
    <@sf.errors path="answer"/><br/>
<button type="submit">Ответить</button>
</@sf.form>