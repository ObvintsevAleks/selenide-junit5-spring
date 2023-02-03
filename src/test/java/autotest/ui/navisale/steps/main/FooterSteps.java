package autotest.ui.navisale.steps.main;

import autotest.ui.navisale.page.main.Footer;
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
public class FooterSteps {

    @Autowired
    private Footer footer;

    @Step("Переход по всем категориям - footer")
    public void goToSubcategory() {
        int i = 0;
        ElementsCollection footerSubCategory = footer.getFooterSubCategory().filter(visible);
        assertAll("Проверка атрибута href для коллекции элементов",
                () -> assertEquals("https://shop.navisale.ru/collection/krossovki", footerSubCategory.get(0).getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/collection/odezhda", footerSubCategory.get(1).getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/collection/sumki-i-ryukzaki", footerSubCategory.get(2).getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/collection/aksessuary", footerSubCategory.get(3).getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/page/contacts", footerSubCategory.get(4).getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/page/dostavka-i-oplata", footerSubCategory.get(5).getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/page/oferta", footerSubCategory.get(6).getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/page/reviews", footerSubCategory.get(7).getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/page/agreement", footerSubCategory.get(8).getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/page/kak-podobrat-razmer", footerSubCategory.get(9).getAttribute("href")),
                () -> assertEquals("https://shop.navisale.ru/page/faq", footerSubCategory.get(10).getAttribute("href"))
        );
        for (SelenideElement e : footerSubCategory) {
            footerSubCategory.get(i).click();
            back();
            i++;
        }
    }

    @Step("Перейти на главную страницу - footer")
    public void goToMainPage() {
        footer.getFooterSiteLogoButton().click();
    }

}
