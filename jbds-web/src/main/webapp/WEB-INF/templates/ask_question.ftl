<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<@sf.form action="${url}" method="post" modelAttribute="questionForm">
    <@sf.input path="question" id="question" placeholder="Вопрос"/>
    <@sf.errors path="question"/><br/>
<button type="submit">Спросить</button>
</@sf.form>