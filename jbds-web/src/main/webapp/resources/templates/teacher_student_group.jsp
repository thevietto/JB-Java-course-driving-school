<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<body>
<h1>Student group</h1>

<a href="/teacher/student_groups/${group.id}/students"><c:out value="состав группы"/></a>

</body>
</html>