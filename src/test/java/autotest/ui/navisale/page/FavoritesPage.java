package autotest.ui.navisale.page;

import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$$x;

@Getter
@Component
public class FavoritesPage {

    ElementsCollection deleteFromFavourite = $$x("//button[@class='button button--empty button--small button--icon button--favorites favorites-added']");

}
