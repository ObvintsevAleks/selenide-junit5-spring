package autotest.ui.navisale.test;

import autotest.ui.navisale.config.SpringConfig;
import autotest.ui.navisale.steps.BaseSteps;
import autotest.ui.navisale.test.data.TestData;
import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.xlstest.XLS;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.SAME_THREAD)
@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {SpringConfig.class})
@RequiredArgsConstructor
public class NavisaleTest extends BaseSteps {

    public void setUp() {
        chromedriver().setup();
        browser = "chrome";
        browserSize = "1920x1080";
        headless = true;
        webdriverLogsEnabled = true;
        downloadsFolder = "target/build/downloads";
        reportsFolder = "target/build/reports";
    }

    @BeforeEach
    public void init() {
        setUp();
        SelenideLogger.addListener("Allure", new AllureSelenide());
    }

    @AfterEach
    public void closeDriver() {
        closeWebDriver();
    }

    @AllureId("1")
    @DisplayName("Переходы: категория - подкатегория - сортировка товара по скидке - добавление в избранное ")
    @Owner("aobvintsev")
    @Story("UI WEB")
    @Tags({@Tag("navisale"), @Tag("ui")})
    @Test
    void case1() {
        step("Открываем страницу shop.navisale.ru", () -> open("https://shop.navisale.ru/"));
        widgetSteps.goToMansBootsCategory();
        defaultCategoryItemSteps.goToSubcategory();
        defaultCategoryItemSteps.chooseSortTypeByDiscount();
        defaultCategoryItemSteps.getFirstItem();
        defaultItemSteps.addAllAnotherItemToFavourite();
        headerSteps.goToFavouriteFromWindow();
    }

    @AllureId("2")
    @DisplayName("Переходы: страница бренда - сортировка по возрасту - добавление в корзину")
    @Owner("aobvintsev")
    @Story("UI WEB")
    @Tags({@Tag("navisale"), @Tag("ui")})
    @Test
    void case2() {
        step("Открываем страницу shop.navisale.ru", () -> open("https://shop.navisale.ru/"));
        widgetSteps.goToMansBootsCategory();
        mainSteps.goToFirstItemPage();
        defaultItemSteps.goToProductBrandPage();
        defaultCategoryItemSteps.chooseSortTypeByAgeItems();
        defaultCategoryItemSteps.getFirstItem();
        defaultItemSteps.addItemToBasket();
        itemAddWindowSteps.goToShopping();
        headerSteps.goToBasketFromWindow();
    }

    @AllureId("3")
    @DisplayName("Переходы: каталог - добавление товара в избранное и в корзину, удаление из страницы избранных товаров и корзины")
    @Owner("aobvintsev")
    @Story("UI WEB")
    @Tags({@Tag("navisale"), @Tag("ui")})
    @Test
    void case3() {
        step("Открываем страницу shop.navisale.ru", () -> open("https://shop.navisale.ru/"));
        widgetSteps.goToManShoesForSportCategory();
        defaultCategoryItemSteps.chooseSortTypeByLowPriceFirst();
        defaultCategoryItemSteps.getFirstItem();
        defaultItemSteps.addItemToBasket();
        itemAddWindowSteps.goToShopping();
        refresh();
        widgetSteps.goWomanSneakersCategory();
        defaultCategoryItemSteps.chooseSortTypeByHighPriceFirst();
        defaultCategoryItemSteps.getFirstItem();
        defaultItemSteps.addItemToBasket();
        itemAddWindowSteps.goToShopping();
        headerSteps.goToBasketFromWindow();
        basketSteps.addAllItemsToFavourite();
        basketSteps.deleteAllItems();
        headerSteps.goToFavouriteFromWindow();
        favoritesSteps.deleteAllFromFavorite();
    }

    @AllureId("4")
    @DisplayName("Переходы: каталог - добавление товара в избранное, удаление из страницы избранных товаров")
    @Owner("aobvintsev")
    @Story("UI WEB")
    @Tags({@Tag("navisale"), @Tag("ui")})
    @Test
    void case4() {
        step("Открываем страницу shop.navisale.ru", () -> open("https://shop.navisale.ru/"));
        widgetSteps.goManSunglassesCategory();
        defaultCategoryItemSteps.chooseSortTypeByPopulatiy();
        defaultCategoryItemSteps.getFirstItem();
        defaultItemSteps.addItemToFavourite();
        refresh();
        widgetSteps.goToManKicksCategory();
        defaultCategoryItemSteps.getFirstItem();
        defaultItemSteps.addItemToFavourite();
        headerSteps.goToFavouriteFromWindow();
        favoritesSteps.deleteAllFromFavorite();
    }


    @AllureId("7")
    @DisplayName("Проверка перехода по категориям - баннеры, header, widget, footer")
    @Owner("aobvintsev")
    @Story("UI WEB")
    @Tags({@Tag("navisale"), @Tag("ui")})
    @Test
    void case7() {
        step("Открываем страницу shop.navisale.ru", () -> open("https://shop.navisale.ru/"));
        mainSteps.goToAllCategoryFromBanner();
        headerSteps.goToAllCategoryFromHeader();
        widgetSteps.goToAllCategoryFromWidget();
        footerSteps.goToMainPage();
        footerSteps.goToSubcategory();
    }

    @AllureId("8")
    @DisplayName("Поиск товаров согласно поисковому запросу")
    @Owner("aobvintsev")
    @Story("UI WEB")
    @Tags({@Tag("navisale"), @Tag("ui")})
    @ParameterizedTest(name = "В корзине появится товар согласно поисковому запросу - {0} и {1}")
    @CsvSource(textBlock = """
                    футболка ; кроссовки
                    кеды     ; обувь
                    толстовка; городские
                    очки     ; через плечо
            """,
            delimiter = ';')
    void case8(String query, String query2) {
        step("Открываем страницу shop.navisale.ru", () -> open("https://shop.navisale.ru/"));
        headerSteps.inputHeaderQuery(query);
        defaultCategoryItemSteps.getFirstItem();
        defaultItemSteps.addItemToBasket();
        itemAddWindowSteps.goToShopping();
        headerSteps.inputHeaderQuery(query2);
        defaultCategoryItemSteps.getFirstItem();
        defaultItemSteps.addItemToBasket();
        itemAddWindowSteps.goToShopping();
        headerSteps.goToBasket();
        basketSteps.deleteAllItems();
    }

    @AllureId("9")
    @DisplayName("Поиск товара по категориям с настройкой фильтра для товаров")
    @Owner("aobvintsev")
    @Story("UI WEB")
    @Tags({@Tag("navisale"), @Tag("ui")})
    @ParameterizedTest(name = "В поисковом запросе выдается товар из {0} {2}")
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
                    категория               ;moreOption;фирма      ;color ;size
                    Футболки мужские        ;true      ;Reebok     ;Черный;L
                    Обувь мужская           ;false     ;Puma       ;      ;
                    Обувь мужская спортивная;false     ;Reebok     ;      ;
                    Кроссовки женские       ;true      ;New Balance;      ;
                    Толстовки мужские       ;true      ;Nike       ;      ;M
                    Футболки женские        ;true      ;New Balance;Серый ;S
                    Толстовки женские       ;true      ;New Balance;Синий ;
            """, delimiter = ';')
    void case9(String category, Boolean moreOption, String brand, String color, String size) {
        step("Открываем страницу shop.navisale.ru", () -> open("https://shop.navisale.ru/"));
        widgetSteps.chooseCategory(category);
        filterSteps.getMoreOptions(moreOption);
        filterSteps.chooseBrand(brand);
        filterSteps.chooseColor(color);
        filterSteps.chooseSize(size);
        defaultCategoryItemSteps.getFirstItem();
        defaultItemSteps.addItemToBasket();
        itemAddWindowSteps.close();
        headerSteps.goToBasket();
    }

    @AllureId("10")
    @SneakyThrows
    @DisplayName("Работа с пдф файлом")
    @Owner("aobvintsev")
    @Story("UI FILE")
    @Tags({@Tag("pdf"), @Tag("file"), @Tag("ui")})
    @Test
    void case10() {
        step("Нужен только файл - меняю pageLoadStrategy с default на eager", () -> pageLoadStrategy = "eager");
        step("Открываем страницу с pdf файлом", () -> open("https://junit.org/junit5/docs/current/user-guide/"));
        File downloadedFile = step("Скачал файл", () -> $("a[href='junit-user-guide-5.9.3.pdf']").download());
        PDF content = step("Подключаю библиотеку для работы с загруженным файлом", () -> new PDF(downloadedFile));
        step("Проверки pdf документа", () -> assertAll("Проверка пдф документа",
                        () -> assertEquals("JUnit 5 User Guide", content.title),
                        () -> assertTrue(content.author.contains("Stefan Bechtold")),
                        () -> assertTrue(content.producer.contains("Stefan Bechtold")),
                        () -> assertEquals("2023-04-26T09:59:32", LocalDateTime.ofInstant(content.creationDate.getTime().toInstant(), ZoneId.systemDefault()).toString()),
                        () -> assertFalse(content.encrypted),
                        () -> assertNull(content.keywords)
                )
        );
    }

    @AllureId("11")
    @SneakyThrows
    @DisplayName("Работа с excel файлом")
    @Owner("aobvintsev")
    @Story("UI FILE")
    @Tags({@Tag("excel"), @Tag("file")})
    @Test
    void case11() {
        step("Долгая загрузка сайта и нужен только файл - меняю pageLoadStrategy с default на eager", () -> pageLoadStrategy = "eager");
        TestData data = step("Инициализируем дату", TestData::new);
        List<List<String>> testData = step("Создаём список с тестовыми данными", data::getTestData);
        List<HashMap<String, String>> sample = step("Создаём коллекцию с данными из загруженного excel файла", () -> new ArrayList<>());
        step("Открываем страницу с excel файлом", () -> open("https://filesamples.com/formats/xlsx"));
        File downloadedFile = step("Скачиваем excel файл", () -> $("a[href='/samples/document/xlsx/sample1.xlsx']").download());
        XLS content = step("Подключаем XLS библиотеку для получения данных из файла", () -> new XLS(downloadedFile));
        Sheet sheet = step("Получаем данные первой страницы/листа из загруженного документа", () -> content.excel.getSheetAt(0));
        int firstRow = step("Получаем первую строку excel документа", () -> content.excel.getSheetAt(0).getFirstRowNum());
        int lastRow = step("Получаем последнюю строку excel документа", () -> content.excel.getSheetAt(0).getLastRowNum());
        step("Итерируемся по документу, заполняем коллекцию sample данными", () -> {
                    for (int i = firstRow + 1; i <= lastRow; i++) {
                        Row row = sheet.getRow(i);
                        HashMap<String, String> excel = new HashMap<>();
                        excel.put("Postcode", row.getCell(0).getStringCellValue());
                        excel.put("Sales_Rep_ID", Double.toString(row.getCell(1).getNumericCellValue()));
                        excel.put("Sales_Rep_Name", row.getCell(2).getStringCellValue());
                        excel.put("Year", Double.toString(row.getCell(3).getNumericCellValue()));
                        excel.put("Value", Double.toString(row.getCell(4).getNumericCellValue()));
                        sample.add(excel);
                    }
                }
        );
        step("Сравниваем тестовые данные с данными из excel файла", () -> assertAll("Проверка выборки из excel файла",
                        () -> assertFalse(sample.isEmpty()),
                        () -> assertEquals(390, sample.size()),
                        () -> assertTrue(sample.stream().flatMap(e -> Stream.of(e.get("Sales_Rep_Name"))).distinct().toList().containsAll(testData.get(0))),
                        () -> assertTrue(sample.stream().flatMap(e -> Stream.of(e.get("Year"))).distinct().map(e -> e.substring(0, 4)).toList().containsAll(testData.get(1))),
                        () -> assertTrue(sample.stream().flatMap(e -> Stream.of(e.get("Sales_Rep_ID"))).distinct().map(e -> e.substring(0, 3)).toList().containsAll(testData.get(2))),
                        () -> assertTrue(sample.stream().flatMap(e -> Stream.of(e.get("Postcode"))).distinct().toList().containsAll(testData.get(3)))
                )
        );
    }


    @AllureId("5")
    @Disabled("Товары из категории хиты продаж отсутствуют")
    @DisplayName("Операции с товаром из категории хиты продаж и женская одежда(баннер)")
    @Owner("aobvintsev")
    @Story("UI WEB")
    @Tags({@Tag("navisale"), @Tag("ui")})
    @Test
    void case5() {
        step("Открываем страницу shop.navisale.ru", () -> open("https://shop.navisale.ru/"));
        mainSteps.goHotProduct();
        mainSteps.goToFirstItemPage();
        defaultItemSteps.addItemToBasket();
        itemAddWindowSteps.goToShopping();
        headerSteps.goToMainPage();
        mainSteps.goToCategoryFromBanner();
        defaultCategoryItemSteps.getFirstItem();
        defaultItemSteps.addItemToBasket();
        itemAddWindowSteps.close();
        headerSteps.goToBasketFromWindow();
        basketSteps.deleteAllItems();
    }

    @AllureId("6")
    @Disabled("Товары из категории хиты продаж и товары на первой странице отсутствуют")
    @DisplayName("Добавление всех товаров из подборок на главной странице в избранное, корзину, удаление товаров")
    @Owner("aobvintsev")
    @Story("UI WEB")
    @Tags({@Tag("navisale"), @Tag("ui")})
    @Test
    void case6() {
        step("Открываем страницу shop.navisale.ru", () -> open("https://shop.navisale.ru/"));
        mainSteps.addAllItemsToBasket();
        mainSteps.addAllItemsToFavorite();
        mainSteps.goHotProduct();
        mainSteps.addAllItemsToBasket();
        mainSteps.addAllItemsToFavorite();
        headerSteps.goToBasketFromWindow();
        basketSteps.deleteAllItems();
        headerSteps.goToFavouriteFromWindow();
        favoritesSteps.deleteAllFromFavorite();
    }


}
