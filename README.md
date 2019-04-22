FastHub-auto-testing
====================

Смотри пакет /app/src/androidTest/java/tech/zherdev/hw10

При помощи UI Automator 2.1.3 выполнены тесты:

* "Открытие Trending". Смотри /test/OpenTrendingTest.java
* "Смена темы". Смотри /test/ChangeThemeTest.java. Примечание: в UI Automator непосредственно нет возможности получить цвет элемента (Скриншот?..), поэтому для проверки мы пользуемся тем, что третья тема (справа от второй), является premium. Это и необходимо проверить. На устройстве Xiaomi Redmi 5 Plus тема не меняется, остается светлой, тест падает.
* "Верстка". Смотри /test/DesignTest.java. Примечание: UI Automator не имеет возможности проверить конкретный source иконки, только ее наличие.
* "Проверка Toast". Смотри /test/ToastTest.java. Приечание: UI Automator не имеет возможности проверить toast, поэтому проверяем только device information.

Тест "Restore Purchases" не подлежит автоматизации UI Automator'ом, т.к. нет возможности проверить intent.


Внимание!
---------

Разместите в каталоге /app/src/androidTest/assets/ файл authData.txt для авторизации в приложении.

Пример:

```
login
pass
```


Логгирование
------------

Для просмотра тестовых логов смотрите тег "tech.zherdev" в Logcat.


Автор тестов
------------

Ivan Zherdev.




>FastHub License
>
> Copyright (C) 2017 Kosh.  
> Licensed under the [GPL-3.0](https://www.gnu.org/licenses/gpl.html) license.  
> (See the [LICENSE](https://github.com/k0shk0sh/FastHub/blob/master/LICENSE) file for the whole license text.)
