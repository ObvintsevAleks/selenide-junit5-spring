package autotest.ui.navisale.steps;

import autotest.ui.navisale.page.FavoritesPage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FavoritesSteps {

    @Autowired
    private FavoritesPage favoritesPage;

    @Step("Удалить все товары - избранное")
    public void deleteAllFromFavorite(){
        favoritesPage.getDeleteFromFavourite().forEach(SelenideElement::click);
    }


}
