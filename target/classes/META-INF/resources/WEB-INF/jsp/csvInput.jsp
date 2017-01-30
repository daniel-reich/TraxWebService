<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Data</title>
</head>
<body>


<form id="fileuploadForm" action="uploadStationData" method="POST" enctype="multipart/form-data">
    <label for="file">File</label>
    <input id="file" type="file" name="csvFile" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <p><button type="submit">Upload</button></p>
</form>


</body>
</html>