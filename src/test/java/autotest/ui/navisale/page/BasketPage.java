package autotest.ui.navisale.page;

import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$$x;

@Getter
@Component
public class BasketPage {


    ElementsCollection
            deleteItemButtons = $$x("//button[@class='button button--empty button--icon button--medium button--remove']"),
            addItemsToFavouriteButtons = $$x("//button[@class='button button--empty button--icon button--medium button--favorites favorites-not-added']"),
            deleteItemsFromFavouriteButtons = $$x("//button[@class='button button--empty button--icon button--medium button--favorites favorites-added']"),
            cutItemsButtons = $$x("//button[@data-quantity-change='-1']"),
            addMoreItemsButtons = $$x("//button[@data-quantity-change='1']");


}
