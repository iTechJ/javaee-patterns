<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div>
    <section>
        <h1> ${data.name} <small> Advanced</small> </h1>
        <p>
            Обратите внимание: эта версия страниц использует такой же список команд, как и версия "Basic".
            Однако, команда для разных версий страниц имеют особенности в обработке или источнике данных.
            Например, в одном случае данные берутся из базы данных, во втором - запрашиваются из платного стороннего вер-сервиса
        </p>

        <p> ${data.description} </p>

        <form class="navigation-form" action="/page1" method="POST">
            <input type="hidden" name="command" value="viewPage1"/>
            <input type="hidden" name="application" value="advanced"/>
            <input type="submit" value="Перейти на Страницу 1"/>
        </form>

        <form class="navigation-form" action="/page2" method="POST">
            <input type="hidden" name="command" value="viewPage2"/>
            <input type="hidden" name="application" value="advanced"/>
            <input type="submit" value="Перейти на Страницу 2"/>
        </form>

        <form class="navigation-form" action="/welcome" method="POST">
            <input type="hidden" name="command" value="viewWelcome"/>
            <input type="hidden" name="application" value="basic"/>
            <input type="submit" value="Переключится к приложению Basic"/>
        </form>
        <p>Application Controller позволяет поддерживать новые варианты реализации логики путем добавления нового кода, а не изменения уже существующего.</p>
    </section>
</div>
