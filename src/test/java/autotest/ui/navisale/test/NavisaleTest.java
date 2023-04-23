package autotest.ui.navisale.test;

import autotest.ui.navisale.config.SpringConfig;
import autotest.ui.navisale.steps.BaseSteps;
import io.qameta.allure.Owner;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.qameta.allure.Allure.description;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {SpringConfig.class})
@RequiredArgsConstructor
public class NavisaleTest extends BaseSteps {

    public void setUp() {
        chromedriver().setup();
        browser = "chrome";
        browserSize = "1920x1080";
        headless = false;
    }

    @BeforeEach
    public void init() {
        setUp();
    }

    @AfterEach
    public void closeDriver() {
        closeWebDriver();
    }

    @DisplayName("Переходы -> категория - подкатегория - сортировка товара по скидке - добавление в избранное ")
    @Owner("aobvintsev")
    @Tag("navisale")
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

    @DisplayName("Переходы -> страница бренда - сортировка по возрасту - добавление в корзину")
    @Owner("aobvintsev")
    @Tag("navisale")
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

    @DisplayName("Переходы -> каталог - добавление товара в избранное и в корзину, удаление из страницы избранных товаров и корзины")
    @Owner("aobvintsev")
    @Tag("navisale")
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

    @DisplayName("Переходы -> каталог - добавление товара в избранное, удаление из страницы избранных товаров")
    @Owner("aobvintsev")
    @Tag("navisale")
    @Test
    void case4() {
        open("https://shop.navisale.ru/");
        widgetSteps.goWomanSunglassesCategory();
        defaultCategoryItemSteps.chooseSortTypeByPopulatiy();
        defaultCategoryItemSteps.getFirstItem();
        defaultItemSteps.addItemToFavourite();
        refresh();
        widgetSteps.goWomanKicksCategory();
        defaultCategoryItemSteps.getFirstItem();
        defaultItemSteps.addItemToFavourite();
        headerSteps.goToFavouriteFromWindow();
        favoritesSteps.deleteAllFromFavorite();
    }


    @DisplayName("Операции с товаром из категории хиты продаж и женская одежда(баннер)")
    @Owner("aobvintsev")
    @Tag("navisale")
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

    @DisplayName("Добавление всех товаров из подборок на главной странице в избранное, корзину, удаление товаров")
    @Owner("aobvintsev")
    @Tag("navisale")
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

    @DisplayName("Проверка перехода по категориям - баннеры, header, widget, footer")
    @Owner("aobvintsev")
    @Tag("navisale")
    @Test
    void case7() {
        open("https://shop.navisale.ru/");
        mainSteps.goToAllCategoryFromBanner();
        headerSteps.goToAllCategoryFromHeader();
        widgetSteps.goToAllCategoryFromWidget();
        footerSteps.goToMainPage();
        footerSteps.goToSubcategory();
    }

    @DisplayName("Поиск товаров согласно поисковому запросу")
    @Owner("aobvintsev")
    @Tag("navisale")
    @ParameterizedTest
    @CsvFileSource(resources = "/navisale/case1.csv", delimiter = ';', numLinesToSkip = 1)
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

    @DisplayName("Поиск товара по категориям с настройкой фильтра для товаров")
    @Owner("aobvintsev")
    @Tag("navisale")
    @ParameterizedTest
    @CsvFileSource(resources = "/navisale/case2.csv", delimiter = ';', numLinesToSkip = 1)
    void case9(String category, Boolean moreOption, String brand, String color, String size, String description) {
        description(description);
        open("https://shop.navisale.ru/");
        widgetSteps.chooseCategory(category);
        if (moreOption) {
            filterSteps.getMoreOptions();
        }
        if (!brand.equals("null")) {
            filterSteps.chooseBrand(brand);
        }
        if (!color.equals("null")) {
            filterSteps.chooseColor(color);
        }
        if (!size.equals("null")) {
            filterSteps.chooseSize(size);
        }
        defaultCategoryItemSteps.getFirstItem();
        defaultItemSteps.addItemToBasket();
        itemAddWindowSteps.close();
        headerSteps.goToBasket();

    }


}
