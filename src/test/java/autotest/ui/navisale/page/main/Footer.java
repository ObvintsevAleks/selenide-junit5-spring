package autotest.ui.navisale.page.main;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
@Component
public class Footer {

    SelenideElement footerSiteLogoButton = $x("//div[@class='footer-menu-title']//a");
    ElementsCollection footerCategoryAndMainPageButton = $$x("//div[@class='footer-menu-title']");
    ElementsCollection footerSubCategory = $$x("//li[@class='footer-menu-item']//a");

}
