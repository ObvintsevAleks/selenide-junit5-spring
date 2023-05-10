package autotest.ui.navisale.steps.main;

import autotest.ui.navisale.page.DefaultCategoryItemPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilterSteps {

    @Autowired
    DefaultCategoryItemPage defaultCategoryItemPage;

    @Step("Фильтр - сортировка по цвету")
    public void chooseColor(String color) {
        defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text(color)).click();
    }

    @DisplayName("Фильтр - сортировка по размеру")
    public void chooseSize(String size) {
        defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text(size)).click();
    }

    @Step("Фильтр - показать ещё варианты")
    public void getMoreOptions() {
        defaultCategoryItemPage.getFilterValueMoreButtons().forEach(SelenideElement::click);
    }

    @Step("Фильтр -  сортировка по бренду")
    public void chooseBrand(String brand) {
        defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text(brand)).click();
    }

}
