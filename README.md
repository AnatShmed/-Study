# lab3
Вимоги:
- Запускати можна лише на операційних системах сімейства Windows
- Необхідний Eclipse(IDE) для Java, посилання на офійний сайт: https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers
- Необхідне JDK версії 12 або 13, посилання: https://jdk.java.net/
- Необхідний встановлений Chrome версії 87.0.4280.88 або можна замінити chromedriver на відвовідний вашій версії Chrome (замінити chromedriver в папці src/test/resourses/chromedriver) 
Налаштування Eclipse:
  1. Відкрити як проект папку SeleniumTests;
  2. В Properties для SeleniumTests перейти на вкладку Java Compiler і обрати Compiler compliance level 9
  3. У вкладці Java Build Path додати бібліотеку(якщо воне вже не стоїть за замовчуванням) JRE System Library [jdk-12]/[jdk-13]
 Запуск тестів
  Після налаштування для запуску всіх тестів необхідно вибрати Run SeleniumTests у списку біля Run(дефолтний значок запуску на панелі зверху)
