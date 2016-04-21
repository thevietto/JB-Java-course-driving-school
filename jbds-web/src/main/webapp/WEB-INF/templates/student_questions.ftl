<#list questions as q>
<a href="${url}/${q.id}/answers">${q.question}</a><br/><hr/>
</#list>

<p><a href="${url}/new">Задать вопрос</a></p>