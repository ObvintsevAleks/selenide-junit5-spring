package autotest.ui.navisale.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
@Component
public class NewOrderPage {

    SelenideElement createOrderButton = $x("//button[@id='create_order']");
    SelenideElement loginOrRegistrationButton = $x("//button[@class='co-button co-button--checkout co-button--checkout-login js-modal-toggler']");
    SelenideElement checkoutForm = $x("//div[@class='co-delivery_method-list co-checkout-block']");
    ElementsCollection checkoutFormFields = $$x("//label[@class='co-input-label']");
    SelenideElement confidentialPolicyLinkButton = $x("//a[@target='blank']");

}
