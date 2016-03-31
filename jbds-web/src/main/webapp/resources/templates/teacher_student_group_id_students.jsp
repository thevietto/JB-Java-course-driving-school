<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<body>
<h1>Student group</h1>

<c:forEach var="student" items="${students}">
    <a href="/teacher/student_groups/${student.studentGroup.id}/students/${student.id}"><c:out
            value="${student.fio}"/></a>
    <br/>
</c:forEach>
</body>
</html>