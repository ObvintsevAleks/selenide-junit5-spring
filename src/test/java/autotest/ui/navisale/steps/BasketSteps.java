package autotest.ui.navisale.steps;

import autotest.ui.navisale.page.BasketPage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasketSteps {

    @Autowired
    BasketPage basketPage;

    @Step("Удаление всех товаров - корзина")
    public void deleteAllItems() {
        basketPage.getDeleteItemButtons().forEach(SelenideElement::click);
    }

    @Step("Добавление всех товаров в избранное - корзина")
    public void addAllItemsToFavourite() {
        basketPage.getAddItemsToFavouriteButtons().forEach(SelenideElement::click);
    }

}

