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
        <th> Transit Network </th>
        <th> | </th>
        <th> Station ID </th>
        <th> | </th>
        <th> Name </th>
        <th> | </th>
        <th> Address </th>
        <th> | </th>
        <th> City </th>
        <th> | </th>
        <th> Line </th>
        <th> | </th>
        <th> Latitude 1 </th>
        <th> | </th>
        <th> Longitude 1 </th>
        <th> | </th>
        <th> Latitude 2 </th>
        <th> | </th>
        <th> Longitude 2 </th>

    </tr>
    <c:forEach var="station" items="${stations}">
        <tr>
            <td><c:out value="${station.transitNetworkName}" /></td>
            <th> | </th>
            <td><c:out value="${station.stationId}" /></td>
            <th> | </th>
            <td><c:out value="${station.stationName}" /></td>
            <th> | </th>
            <td><c:out value="${station.stationAddress}" /></td>
            <th> | </th>
            <td><c:out value="${station.city}" /></td>
            <th> | </th>
            <td><c:out value="${station.line}" /></td>
            <th> | </th>
            <td><c:out value="${station.lat1}" /></td>
            <th> | </th>
            <td><c:out value="${station.long1}" /></td>
            <th> | </th>
            <td><c:out value="${station.lat2}" /></td>
            <th> | </th>
            <td><c:out value="${station.long2}" /></td>

        </tr>
    </c:forEach>
</table>

<a href="/addStation">Add Station</a><br>
<a href="/">View Dashboard</a><br>
</body>
</html>