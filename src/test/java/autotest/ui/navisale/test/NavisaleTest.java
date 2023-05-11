package autotest.ui.navisale.test;

import autotest.ui.navisale.config.SpringConfig;
import autotest.ui.navisale.steps.BaseSteps;
import autotest.ui.navisale.test.data.testData;
import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
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
        open("https://shop.navisale.ru/");
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
        open("https://shop.navisale.ru/");
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
        open("https://shop.navisale.ru/");
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
        open("https://shop.navisale.ru/");
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
        open("https://shop.navisale.ru/");
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
        open("https://shop.navisale.ru/");
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
        open("https://shop.navisale.ru/");
        widgetSteps.chooseCategory(category);
        if (moreOption) {
            filterSteps.getMoreOptions();
        }
        if (brand != null) {
            filterSteps.chooseBrand(brand);
        }
        if (color != null) {
            filterSteps.chooseColor(color);
        }
        if (size != null) {
            filterSteps.chooseSize(size);
        }
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
        pageLoadStrategy = "eager";
        open("https://junit.org/junit5/docs/current/user-guide/");
        File downloadedFile = $("a[href='junit-user-guide-5.9.3.pdf']").download();
        PDF content = new PDF(downloadedFile);
        assertAll("Проверка пдф документа",
                () -> assertEquals("JUnit 5 User Guide", content.title),
                () -> assertTrue(content.author.contains("Stefan Bechtold")),
                () -> assertTrue(content.producer.contains("Stefan Bechtold")),
                () -> assertEquals("2023-04-26T09:59:32", LocalDateTime.ofInstant(content.creationDate.getTime().toInstant(), ZoneId.systemDefault()).toString()),
                () -> assertFalse(content.encrypted),
                () -> assertNull(content.keywords)
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
        pageLoadStrategy = "eager";
        testData data = new testData();
        List<List<String>> testData = data.getTestData();
        List<HashMap<String, String>> sample = new ArrayList<>();
        open("https://filesamples.com/formats/xlsx");
        File downloadedFile = $("a[href='/samples/document/xlsx/sample1.xlsx']").download();
        XLS content = new XLS(downloadedFile);
        Sheet sheet = content.excel.getSheetAt(0);
        int firstRow = content.excel.getSheetAt(0).getFirstRowNum();
        int lastRow = content.excel.getSheetAt(0).getLastRowNum();
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
        assertAll("Проверка выборки из excel файла",
                () -> assertFalse(sample.isEmpty()),
                () -> assertEquals(390, sample.size()),
                () -> assertTrue(sample.stream().flatMap(e -> Stream.of(e.get("Sales_Rep_Name"))).distinct().toList().containsAll(testData.get(0))),
                () -> assertTrue(sample.stream().flatMap(e -> Stream.of(e.get("Year"))).distinct().map(e -> e.substring(0, 4)).toList().containsAll(testData.get(1))),
                () -> assertTrue(sample.stream().flatMap(e -> Stream.of(e.get("Sales_Rep_ID"))).distinct().map(e -> e.substring(0, 3)).toList().containsAll(testData.get(2))),
                () -> assertTrue(sample.stream().flatMap(e -> Stream.of(e.get("Postcode"))).distinct().toList().containsAll(testData.get(3)))
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
        open("https://shop.navisale.ru/");
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
        open("https://shop.navisale.ru/");
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
