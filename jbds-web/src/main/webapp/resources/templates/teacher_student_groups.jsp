<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<body>
<h1>Student groups</h1>

<c:forEach var="group" items="${groups}">
    <a href="/teacher/student_groups/${group.id}"><c:out value="номер ${group.id}"/><br/></a>
    <c:out value="количество студентов ${group.students.size()}"/><br/>
    <br/>
</c:forEach>

</body>
</html>