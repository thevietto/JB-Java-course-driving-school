<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: aleksandrpliskin
  Date: 18.03.16
  Time: 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<sf:form action="/admin/add_students" method="post" modelAttribute="userform">

    <sf:label path="firstname">Имя: </sf:label> <sf:input path="firstname"/>
    <sf:label path="surname">Фамилия: </sf:label> <sf:input path="surname"/>
    <sf:label path="lastname">rОтчество: </sf:label> <sf:input path="lastname"/>

    <button type="submit">Сохранить</button>
</sf:form>

</body>
</html>
