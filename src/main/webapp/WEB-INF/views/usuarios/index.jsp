<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Usuarios</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,400italic,700,800' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:300,200,100' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div class="container-fluid" id="pcont">

            <div class="cl-mcont">
                <div class="row">
                    <div class="col-md-12">
                        <div class="block-flat">
                            <div class="header">
                                <h3>Usuarios</h3>
                                <a href="nuevo" class="btn btn-primary pull-right" style="margin-top: -40px;">Nuevo</a>
                            </div>
                            <div class="content">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="datatable">
                                        <thead>
                                            <tr>
                                                <th>Foto</th>
                                                <th>id</th>
                                                <th>Nombre</th>
                                                <th>Direccion</th>
                                                <th>Telefono</th>
                                                <th>Acci&oacute;n</th>
                                            </tr> </thead>
                                        <tbody>
                                            <c:forEach var="user" items="${usuarioList}">
                                                <tr>
                                                    <td><img src="<c:url value="/${user.imagen.url}"/>" width="80px" height="80px"/>  </td>
                                                    <td>${user.idusuario}</td>
                                                    <td>${user.nombre}</td>
                                                    <td>${user.direccion}</td>
                                                    <td>${user.telefono}</td>
                                                    <td></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   
    </body>
</html>
