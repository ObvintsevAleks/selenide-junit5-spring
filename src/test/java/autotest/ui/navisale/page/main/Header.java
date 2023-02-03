package autotest.ui.navisale.page.main;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
@Component
public class Header {


    ElementsCollection headerCategoryCollection = $$x("//li[@class='nav-item js-nav-item']");
    SelenideElement headerSiteLogoButton = $x("//div[@class='col-12 col-sm col-md col-lg-auto text-center text-lg-left']");
    SelenideElement headerInputField = $x("//input[@class='search-input js-search-input']");
    SelenideElement headerInputFieldButton = $x("//button[@class='search-button']");
    SelenideElement headerFavoriteEmptyItemButton = $x("//a[@class='user_icons-icon js-user_icons-icon-favorites']"); // могут быть проблемы, по селектору 2 элемента
    SelenideElement headerFavoriteNotEmptyItemButton = $x("//a[@class='user_icons-icon js-user_icons-icon-favorites is-active']"); // могут быть проблемы, по селектору 2 элемента
    ElementsCollection headerGoToFavouriteFromWindow = $$x("//div[@class='js-popup-favorites']//div[@class='col-12']//a");
    SelenideElement headerLoginUserButton = $x("//a[@class='user_icons-icon']"); // могут быть проблемы, по селектору 2 элемента
    SelenideElement headerAuthorizeButton = $x("//a[@class='button button--primary button--block button--small']"); // могут быть проблемы, по селектору 2 элемента
    SelenideElement headerRegistrationButton = $x("//a[@class='button button--secondary button--block button--small']"); // могут быть проблемы, по селектору 2 элемента
    SelenideElement headerBasketButton = $x("//span[@class='row align-items-center no-gutters']"); // могут быть проблемы, по селектору 2 элемента
    SelenideElement headerDeleteItemFromBasketButton = $x("//button[@class='button button--empty button--icon button--remove']"); // могут быть проблемы, по селектору 2 элемента
    SelenideElement headerOpenBasketIfHaveItemButton = $x("//div[@class='col-12 col-lg-6']//a[@href='/cart_items']"); // могут быть проблемы, по селектору 2 элемента
    SelenideElement headerProcessedCheckoutButton = $x("//a[@class='button button--secondary button--block button--small']"); // могут быть проблемы, по селектору 2 элемента

}
