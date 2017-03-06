<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="utf-8">
        <title>Составное представление</title>
        <link href="../css/main.css" rel="stylesheet" type="text/css">
    </head>
    <body>
     <jsp:include page="${page.header}" flush="true"/>
        <div>
            <jsp:include page="${page.body}" flush="true"/>
        </div>
        <jsp:include page="${page.footer}" flush="true"/>
    </body>
</html>
