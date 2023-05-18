package autotest.ui.navisale.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
@Component
public class DefaultItemPage {

    SelenideElement
            getReviewButton = $x("//a[@class='js-rating-link']"),
            productAddButton = $x("//div[@class='product-add']"),
            addItemToFavouriteButton = $x("//button[@class='button button--empty button--icon button--favorites favorites-not-added']"),
            productBrandButton = $x("//div[@class='product-brand']"),
            previousItemButton = $x("//button[@class='owl-prev']"),
            nextItemButton = $x("//button[@class='owl-next']");

    ElementsCollection
            charactersItemAndUserReviewsButtons = $$x("//div[@class='row no-gutters justify-content-center tabs-list']//div"),
            goToCategoryButtons = $$x("//div[@class='product-collections']//a"),
            itemsCollection = $$x("//a[@class='product_card-thumb product_card-thumb--1x1 product_card-thumb--contain']"),
            addAnotherItemToBasketButtons = $$x("//div[@class='product_card-add row no-gutters']//div[@class='col']/a"),
            addAnotherItemToFavouriteButtons = $$x("//div[@class='product_card-add row no-gutters']//div[@class='col col-auto']");

}
