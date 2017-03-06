<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div>
    <section>
        <h1> ${data.name} <small>Basic</small> </h1>
        <p>
            Обратите внимание: эта версия страниц использует такой же список команд, как и версия "Advanced".
            Однако, команда для разных версий страниц имеют особенности в обработке или источнике данных.
            Очень может быть, что страницы так же имеют различия (возможно, незначительные).
            Так или иначе, вы хотите избавиться от постоянных проверок версии приложения в запросе...
            Для этого и нужен Application Controller
        </p>

        <p> ${data.description} </p>
        <p> Вот этого параграфа нет в другой версии страниц</p>

        <form class="navigation-form" action="/page1" method="POST">
            <input type="hidden" name="command" value="viewPage1"/>
            <input type="hidden" name="application" value="basic"/>
            <input type="submit" value="Перейти на Страницу 1"/>
        </form>

        <form class="navigation-form" action="/page2" method="POST">
            <input type="hidden" name="command" value="viewPage2"/>
            <input type="hidden" name="application" value="basic"/>
            <input type="submit" value="Перейти на Страницу 2"/>
        </form>

        <form class="navigation-form" action="/welcome" method="POST">
            <input type="hidden" name="command" value="viewWelcome"/>
            <input type="hidden" name="application" value="advanced"/>
            <input type="submit" value="Переключится к приложению Advanced"/>
        </form>
    </section>
</div>
