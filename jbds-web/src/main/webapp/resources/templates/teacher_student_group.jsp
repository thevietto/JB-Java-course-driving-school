<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<body>
<h1>Student group</h1>

<%--<c:out value="количество студентов ${group.students.size()}"/><br/>--%>

<c:forEach var="student" items="${group.students}">
    <c:out value="fio" ${student.fio}/>
</c:forEach>

</body>
</html>