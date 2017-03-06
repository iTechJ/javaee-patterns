<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<section>
    <h1> ${data.name} </h1>

    <p> ${data.description} </p>

    <form class="navigation-form" action="/page2" method="POST">
        <input type="hidden" name="command" value="viewPage1"/>
        <input type="submit" value="Совершить какое-то действие"/>
    </form>

    <form class="navigation-form" action="/welcome" method="POST">
        <input type="hidden" name="command" value="viewWelcome"/>
        <input type="submit" value="Вернуться назад"/>
    </form>
</section>
