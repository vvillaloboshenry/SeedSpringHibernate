<%-- 
    Document   : defaultLayout
    Created on : 16/01/2018, 09:00:12 AM
    Author     : gescom
--%>

<%@page language="java" contentType="text/html; charset=charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:getAsString name="title" /></title>
        <link href="<c:url value='/css/app.css' />" rel="stylesheet">
    </head>
    <body>
        <div class="flex-container">
            <tiles:insertAttribute name="header" />
            <tiles:insertAttribute name="menu" />
            <article class="article"> <tiles:insertAttribute name="body" />
            </article>
            <tiles:insertAttribute name="footer" />
        </div>

        <script src="<c:url value="/js/jquery.js"/>"></script>
        <script src="<c:url value="/js/require.js"/>"></script>
        <script>
            require.config({
                baseUrl: "${approot}/js",
                urlArgs: "V=" + (new Date()).getTime(),
                waitSeconds: 60,
                paths: {
                },
                packages: [{
                        name: "bootstrap",
                        main: 'js/bootstrap.min'
                    }, {
                        name: "datatables",
                        main: 'dataTables.min'
                    }]
            });
            require(['app/${controller}', 'app/app'], function (${controller}) {

            ${controller}.${action}();
            });
        </script>
        ${controller}.${action}();
    </body>
</html>