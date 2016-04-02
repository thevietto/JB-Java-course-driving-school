<h1>Страница для назначения задания для группы</h1>

<form action="/teacher/student_groups/${group.id}/task" method="post">
<#list tests as test>
    <option> ${test.description}</option>
</#list>
    <button type="submit">Добавить</button>
</form>