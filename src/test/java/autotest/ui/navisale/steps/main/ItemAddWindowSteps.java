package autotest.ui.navisale.steps.main;

import autotest.ui.navisale.page.main.ItemAddWindow;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Component
public class ItemAddWindowSteps {

    @Autowired
    private ItemAddWindow itemAddWindow;

    @Step("Продолжить покупки - модальное окно с товаром")
    public void goToShopping() {
        itemAddWindow.getGoShopping().click();
    }

    @Step("Открыть корзину - модальное окно с товаром")
    public void goToBasket() {
        assertTrue(itemAddWindow.getItemAddToBasketWindow().isDisplayed(), "Окно не отображается!");
        itemAddWindow.getGoToBasketButton().click();
    }

    @Step("Оформить заказ - модальное окно с товаром")
    public void processNewOrder() {
        assertTrue(itemAddWindow.getItemAddToBasketWindow().isDisplayed(), "Окно не отображается!");
        itemAddWindow.getGoToNewOrderProcess().click();
    }

    @Step("Закрыть - модальное окно с товаром")
    public void close() {
        itemAddWindow.getClose().click();
    }

}
