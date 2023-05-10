package autotest.ui.navisale.steps;

import autotest.ui.navisale.page.MainPage;
import autotest.ui.navisale.steps.main.ItemAddWindowSteps;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.back;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Component
public class MainSteps {

    @Autowired
    private MainPage mainPage;
    @Autowired
    private ItemAddWindowSteps itemAddWindowSteps;

    @Step("Переход на страницу первого товара из подборки - главная страница")
    public void goToFirstItemPage() {
        mainPage.getProductsCollection().filter(visible).get(0).click();
    }

    @Step("Добавление списка товаров из подборки в корзину - главная страница")
    public void addAllItemsToBasket() {
        ElementsCollection allItems = mainPage.getAddItemToBasketButtons().filter(visible);
        allItems.asFixedIterable().forEach(SelenideElement::click);
    }

    @Step("Добавление списка товаров из подборки в избранное - главная страница")
    public void addAllItemsToFavorite() {
        ElementsCollection allItems = mainPage.getAddItemToFavouriteButtons().filter(visible);
        allItems.asFixedIterable().forEach(SelenideElement::click);
    }

    @Step("Переключение подборки товаров с категории 'Новинки' в категорию 'Хиты продаж' - главная страница")
    public void goHotProduct() {
        mainPage.getNewAndHitIemCollection().filter(visible).get(0).click();
    }


    @Step()
    public void goToCategoryFromBanner() {
        mainPage.getBigBannerCollection().get(2).click();
    }

    @Step("Переход по категориям через баннеры - главная страница")
    public void goToAllCategoryFromBanner() {
        int i = 0;
        ElementsCollection categoryFromBanner = mainPage.getBigBannerCollection().filter(visible);
        assertAll("Проверка атрибута href для коллекции элементов",
                () -> assertEquals("https://shop.navisale.ru/collection/dlya-nego-2", categoryFromBanner.get(0).lastChild().getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/collection/dlya-neyo-2", categoryFromBanner.get(1).lastChild().getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/collection/beysbolki", categoryFromBanner.get(2).lastChild().getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/collection/ryukzaki", categoryFromBanner.get(3).lastChild().getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/collection/ochki", categoryFromBanner.get(4).lastChild().getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/collection/sumki", categoryFromBanner.get(5).lastChild().getAttribute("href"))
        );
        for (SelenideElement e : categoryFromBanner) {
            assertEquals("banners-thumb banners-thumb--16x9 banners-thumb--cover", categoryFromBanner.get(i).lastChild().getAttribute("class")
                    , "Неправильное значение class для элемента = " + i);
            categoryFromBanner.get(i).click();
            back();
            i++;
        }
    }


}
