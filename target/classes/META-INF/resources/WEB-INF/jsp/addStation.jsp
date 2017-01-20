<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New Station</title>
</head>
<body>

<h1>New Station</h1>


<form action="/saveStation" method="POST">
    Transit Network Name:<input type="text" name="transitNetworkName" required/>
    <br>
    City: <input type="text" name="city" required/>
    <br>
    Station Name:<input type="text" name="stationName" required/>
    <br>
    Station Address:<input type="text" name="stationAddress" required/>
    <br>
    Line: <input type ="text" name="line">
    <br>
    GSP1: <input type="number" name="gps1" required/>
    <br>
    GSP2: <input type="number" name="gps2" required/>
    <br>
    <input type="submit" value="Save Employee"/>
</form>

<a href="/">View Dashboard</a><br>

</body>
</html>