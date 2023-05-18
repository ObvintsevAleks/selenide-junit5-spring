package autotest.ui.navisale.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
@Component
public class MainPage {

    ElementsCollection bigBannerCollection = $$x("//div[@class='col col-12 col-md-6']"),
            headerCategoryCollection = $$x("//li[@class='nav-item js-nav-item']"),
            vkLinkButton = $$x("//li[@class='social-item social-item--vk']"),
            telegramLinkButton = $$x("//li[@class='social-item social-item--telegram-plane']"),
            instagramLinkButton = $$x("//li[@class='social-item social-item--instagram']"),
            changeBannerCategoryButton = $$x("//div[@class='owl-dots']//button[@role='button']"),
            newAndHitIemCollection = $$x("//a[@class='button button--primary']"),
            productsCollection = $$x("//a[@class='product_card-thumb product_card-thumb--1x1 product_card-thumb--contain']"),
            addItemToBasketButtons = $$x("//button[@class='button button--icon button--small button--empty button--empty--inverse']"),
            addItemToFavouriteButtons = $$x("//button[@class='button button--empty button--small button--icon button--favorites favorites-not-added']"),
            deleteItemFromFavouritesButtons = $$x("//button[@class='button button--empty button--small button--icon button--favorites favorites-added']']");

    SelenideElement speakWithCustomerServiceButton = $x("//div[@class='dialogs__widget_btn sc-htoDjs icoNCV']");
}
