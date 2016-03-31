<html>
<body>
<h1>Student groups</h1>


<h1>${student.fio}</h1>
<#if marks?has_content>
    <#list marks as mark>
    <p>${mark.description} : ${mark.mark}     дата: ${mark.createdAt}</p>
    <br/>
    </#list>
</#if>
<form action="/teacher/student_groups/${student.studentGroup.id}/students/${student.id}/student_points" method="post">
    <textarea name="description"></textarea>
    <br/>
    <select name="student_point">
        <option value="5">5</option>
        <option value="4">4</option>
        <option value="3">3</option>
        <option value="2">2</option>
        <option value="1">1</option>
    </select>
    <br/>
    <button type="submit">поставить оценку</button>
</form>

</body>
</html>