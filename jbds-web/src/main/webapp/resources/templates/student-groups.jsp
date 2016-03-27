<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<body>
<h1>Student groups</h1>

<c:forEach var="group" items="${groups}">
    <c:out value="номер ${group.id}"/><br/>
    <c:out value="преподаватель ${group.teacherAccount.fio}"/><br/>
    <c:out value="количество студентов ${group.studentAccountList.size()}"/><br/>
    <c:forEach var="student" items="${group.studentAccountList}">
        <b></b><c:out value="${student.fio}"/></b>
        <a href="/admin/student/<c:out value="${student.id}"/>/change">изменить</a>
        <br/>
    </c:forEach>
    <br/>
</c:forEach>

</body>
</html>