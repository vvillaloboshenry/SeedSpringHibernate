<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link
            href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,400italic,700,800'
            rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:300,200,100'
              rel='stylesheet' type='text/css'>
        <link href="<c:url value="/js/bootstrap/dist/css/bootstrap.css"/>"
              rel="stylesheet">
    </head>
    <body>
        <div>
            <form method="POST" action="uploadFile" enctype="multipart/form-data">
                <label>Imagen a Subir:</label> <input type="file" name="file" size="50" /> 
                <input type="submit" value="Grabar" />
            </form>
        </div>
        ${msg}      


    </body>
</html>
