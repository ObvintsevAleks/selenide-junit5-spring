package autotest.ui.navisale.steps;

import autotest.ui.navisale.page.DefaultItemPage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.visible;

@Component
public class DefaultItemSteps {

    @Autowired
    private DefaultItemPage defaultItemPage;

    @Step("Добавить товар в корзину - страница товара")
    public void addItemToBasket() {
        defaultItemPage.getProductAddButton().click();
    }

    @Step("Добавить товар в избранное - страница товара")
    public void addItemToFavourite() {
        defaultItemPage.getAddItemToFavouriteButton().click();
    }

    @Step("Переход на страницу бренда - страница товара")
    public void goToProductBrandPage() {
        defaultItemPage.getProductBrandButton().shouldBe(visible).click();
    }

    @Step("Добавить первый товар из подборки в корзину - страница товара")
    public void addFirstAnotherItemToBasket() {
        defaultItemPage.getAddAnotherItemToBasketButtons().filter(visible).get(0).click();
    }

    @Step("Добавить все товары из подборки в корзину - страница товара")
    public void addAllAnotherItemToBasket() {
        defaultItemPage.getAddAnotherItemToBasketButtons().filter(visible).asFixedIterable().forEach(SelenideElement::click);
    }

    @Step("Добавить первый товар из подборки в избранное - страница товара")
    public void addFirstAnotherItemToFavourite() {
        defaultItemPage.getAddAnotherItemToFavouriteButtons().filter(visible).get(0).click();
    }

    @Step("Добавить все товары из подборки в избранное - страница товара")
    public void addAllAnotherItemToFavourite() {
        defaultItemPage.getAddAnotherItemToFavouriteButtons().filter(visible).asFixedIterable().forEach(SelenideElement::click);
    }


}
