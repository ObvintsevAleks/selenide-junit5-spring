package autotest.ui.navisale.steps.main;

import autotest.ui.navisale.page.DefaultCategoryItemPage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@Component
public class FilterSteps {

    @Autowired
    DefaultCategoryItemPage defaultCategoryItemPage;

    @Step("Фильтр - сортировка по цвету")
    public void chooseColor(String color) {
        Optional.ofNullable(color).ifPresent(e -> defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(text(color)).click());
    }

    @DisplayName("Фильтр - сортировка по размеру")
    public void chooseSize(String size) {
        Optional.ofNullable(size).ifPresent(e -> defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(text(size)).click());
    }

    @Step("Фильтр - показать ещё варианты")
    public void getMoreOptions(Boolean isMoreOptions) {
        if (isMoreOptions) {
            defaultCategoryItemPage.getFilterValueMoreButtons().filter(visible).asFixedIterable().forEach(SelenideElement::click);
        }
    }

    @Step("Фильтр -  сортировка по бренду")
    public void chooseBrand(String brand) {
        Optional.ofNullable(brand).ifPresent(e -> defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(text(brand)).click());
    }

}
