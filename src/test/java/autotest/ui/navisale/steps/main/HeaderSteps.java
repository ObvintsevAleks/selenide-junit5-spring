package autotest.ui.navisale.steps.main;

import autotest.ui.navisale.page.main.Header;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Component
public class HeaderSteps {

    @Autowired
    private Header header;

    @Step("Проверка перехода по категориям - header")
    public void goToAllCategoryFromHeader() {
        int i = 0;
        ElementsCollection categoryFromHeader = header.getHeaderCategoryCollection().filter(visible);
        assertAll("Проверка атрибута href для коллекции элементов",
                () -> assertEquals("https://shop.navisale.ru/collection/odezhda", categoryFromHeader.get(0).lastChild().getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/collection/krossovki", categoryFromHeader.get(1).lastChild().getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/collection/ryukzaki", categoryFromHeader.get(2).lastChild().getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/collection/sumki", categoryFromHeader.get(3).lastChild().getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/collection/ochki", categoryFromHeader.get(4).lastChild().getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/collection/beysbolki", categoryFromHeader.get(5).lastChild().getAttribute("href"))
        );
        for (SelenideElement e : categoryFromHeader) {
            categoryFromHeader.get(i).click();
            back();
            i++;
        }
    }

    @Step("Переход на главную страницу - header")
    public void goToMainPage() {
        header.getHeaderSiteLogoButton().click();
    }

    @Step("Ввод поискового запроса - header")
    public void inputHeaderQuery(String query) {
        header.getHeaderInputField().click();
        header.getHeaderInputField().sendKeys(query);
        header.getHeaderInputFieldButton().click();
    }

    @Step("Переход в избранное - header")
    public void goToFavourite() {
        header.getHeaderFavoriteNotEmptyItemButton().shouldBe(visible).click();
    }

    @Step("Переход в избранное через выпадающее окно - header")
    public void goToFavouriteFromWindow() {
        header.getHeaderFavoriteNotEmptyItemButton().hover();
        sleep(100);
        header.getHeaderGoToFavouriteFromWindow().filter(visible).get(0).click();
    }

    @Step("Переход в корзину")
    public void goToBasket() {
        header.getHeaderBasketButton().shouldBe(visible).click();
    }

    @Step("Переход в корзину через выпадающее окно - header")
    public void goToBasketFromWindow() {
        header.getHeaderBasketButton().hover();
        sleep(100);
        header.getHeaderOpenBasketIfHaveItemButton().shouldBe(visible).click();
    }

}
