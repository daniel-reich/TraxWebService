<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Web Service</title>
    <link rel="stylesheet" type="text/css" href="test.css">
</head>
<body>
Hello Web Service


<table>
    <tr>
        <th> Name </th>
        <th> | </th>
        <th> City </th>
        <th> | </th>
        <th> Lines </th>
        <th> | </th>
        <th> Stations </th>

    </tr>
    <c:forEach var="network" items="${transitNetworkList}">
        <tr>
            <td><c:out value="${network.transitNetworkName}" /></td>
            <th> | </th>
            <td><c:out value="${network.city}" /></td>
            <th> | </th>
            <td><c:out value="${network.lines}" /></td>
            <th> | </th>
            <td><c:out value="${network.stations}" /></td>

        </tr>
    </c:forEach>
</table>

<a href="/addStation">Add Station</a><br>
</body>
</html>