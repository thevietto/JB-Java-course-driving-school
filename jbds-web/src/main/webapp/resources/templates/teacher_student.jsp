<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<body>
<h1>Student group</h1>

<c:out value="${student.fio}"/>
<a href="/teacher/student_groups/${student.studentGroup.id}/students/${student.id}/student_points">оценки</a>
</body>
</html>