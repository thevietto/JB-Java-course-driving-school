<#list tasks as task>
${task.description}<br/>
${task.deadline}<br/>
${task.status}<br/>
<a href="/student/tasks/${task.id}">решить</a><br/><br/>
</#list>