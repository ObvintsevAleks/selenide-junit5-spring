selenide-junit5-spring-allure

Используются след библиотеки:
JUnit 5 - параметризация, паралелльное выполнение тестов [смотри resource.junit-platform.properties] + в классе TEST используется @Execution(ExecutionMode.CONCURRENT)
Spring - основные используемые аннотации @Bean, @Component, @Autowired, @ContextConfiguration
Selenide - работа с коллекцией элементов, работа с элементами, поиск элементов по Xpath
Allure - добавил только @Step, @Owner, если разберусь с докером то добавлю и остальные
Lombok - основные аннотации @Gettere, @Setter, @RequiredArgsConstrucor