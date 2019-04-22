FastHub-auto-testing
====================

Смотри пакет /app/src/androidTest/java/tech/zherdev/hw10

Выполнены UI тесты:

* "Открытие Trending". Смотри /test/OpenTrendingTest.java
* "Смена темы". Смотри /test/ChangeThemeTest.java. Примечание: в UIAutomator нет возможности получить
цвет элемента, поэтому для проверки мы пользуемся тем, что тема, следующая (правее) после темно-серой, является
премиальной. Это и необходимо проверить. На моем устройстве (Xiaomi Redmi 5 Plus) тема не меняется (тест падает).
* "Верстка". Смотри /test/DesignTest.java. Примечание: UIAutomator не имеет возможности проверить конкретный source иконки,
только ее наличие.
* "Проверка Toast". Смотри /test/ToastTest.java. Приечание: UIAutomator не имеет возможности проверить toast,
поэтому проверяем только device information.


Внимание!
=========

Разместите в каталоге /app/src/androidTest/assets/ файл authData.txt для авторизации в приложении.

Пример:

```
login
pass
```


## Автор тестов

Ivan Zherdev.




## FastHub License

> Copyright (C) 2017 Kosh.  
> Licensed under the [GPL-3.0](https://www.gnu.org/licenses/gpl.html) license.  
> (See the [LICENSE](https://github.com/k0shk0sh/FastHub/blob/master/LICENSE) file for the whole license text.)