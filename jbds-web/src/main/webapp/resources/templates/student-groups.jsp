<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
Student groups

<c:forEach var="group" items="${student_groups}">
    <c:out value="${group}"/>
</c:forEach>