<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<body>
<h1>Student groups</h1>


<h1>${student.fio}</h1>

<c:forEach var="mark" items="${marks}">
    <p>${mark.description} : ${mark.marks}     дата: ${mark.date}</p>
    <br/>
</c:forEach>

<form action="/teacher/student_groups/${student.studentGroup.id}/students/${student.id}/student_points" method="post">
    <textarea name="description"></textarea>
    <br/>
    <select name="student_point">
        <option value="five">5</option>
        <option value="four">4</option>
        <option value="three">3</option>
        <option value="two">2</option>
        <option value="one">1</option>
    </select>
    <br/>
    <button type="submit">поставить оценку</button>
</form>

</body>
</html>