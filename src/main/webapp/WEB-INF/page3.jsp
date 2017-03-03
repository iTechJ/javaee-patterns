<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Фильтры</title>
    <link href="../css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="#">Паттерны</a></li>
            <li><a href="#">${title}</a></li>
        </ul>
    </nav>
</header>
<div>
    <section>
        <h1> ${data.name} </h1>
        <p> ${data.description} </p>
        <form class="navigation-form" action="/page1" method="POST">
            <input type="hidden" name="command" value="viewPage1"/>
            <input type="submit" value="Совершить другие действие"/>
        </form>

        <form class="navigation-form" action="/welcome" method="POST">
            <input type="hidden" name="command" value="viewWelcome"/>
            <input type="submit" value="Вернуться назад"/>
        </form>
    </section>
</div>
<footer>
    <div>
        <p>2017</p>
    </div>
</footer>
</body>
</html>
