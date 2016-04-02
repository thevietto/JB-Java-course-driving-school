<h1>Страница для назначения задания для группы</h1>

<form action="/teacher/student_groups/${group.id}/task" method="post">
    <select name="test_name">
    <#list tests as test>
        <option> ${test.description}</option>
    </#list>
    </select><br/>
    <p><textarea name="description"></textarea></p><br/>
    <button type="submit">Добавить</button>
</form>