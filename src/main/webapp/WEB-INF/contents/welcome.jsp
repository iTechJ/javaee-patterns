<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div>
    <section>
        <h1> ${data.name} </h1>

        <p> ${data.description} </p>

        <form class="navigation-form" action="/page1" method="POST">
            <input type="hidden" name="command" value="viewPage1"/>
            <input type="submit" value="Перейти на Страницу 1"/>
        </form>

        <form class="navigation-form" action="/page2" method="POST">
            <input type="hidden" name="command" value="viewPage2"/>
            <input type="submit" value="Перейти на Страницу 2"/>
        </form>
    </section>
</div>
