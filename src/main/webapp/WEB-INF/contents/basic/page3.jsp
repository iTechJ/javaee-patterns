<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<section>
    <h1> ${data.name} </h1>

    <p> ${data.description} </p>

    <p>Единственное действие - вернуться назад</p>
    <form class="navigation-form" action="/welcome" method="POST">
        <input type="hidden" name="command" value="viewWelcome"/>
        <input type="hidden" name="application" value="basic"/>
        <input type="submit" value="Вернуться назад"/>
    </form>
</section>
