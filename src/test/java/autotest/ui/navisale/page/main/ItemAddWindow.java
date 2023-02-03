package autotest.ui.navisale.page.main;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$x;

@Getter
@Component
public class ItemAddWindow {

    SelenideElement goShopping = $x("//button[@class='button button--empty button--info']");
    SelenideElement goToBasketButton = $x("//a[@class='button button--primary button--block button--large']");
    SelenideElement goToNewOrderProcess = $x("//a[@class='button button--secondary button--block button--large']");
    SelenideElement itemAddToBasketWindow = $x("//div[@class='message message--cart fancybox-content']");
    SelenideElement close = $x("//button[@class='fancybox-close-small']");

}
