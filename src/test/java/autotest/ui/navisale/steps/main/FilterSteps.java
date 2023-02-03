package autotest.ui.navisale.steps.main;

import autotest.ui.navisale.page.DefaultCategoryItemPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.fail;

@Component
public class FilterSteps {

    @Autowired
    DefaultCategoryItemPage defaultCategoryItemPage;

    @Step("Фильтр - сортировка по цвету")
    public void chooseColor(String color) {
        if (color.equalsIgnoreCase("grey") || color.equalsIgnoreCase("серый")) {
            defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text("Серый")).click();
        } else if (color.equalsIgnoreCase("red") || color.equalsIgnoreCase("красный")) {
            defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text("Красный")).click();
        } else if (color.equalsIgnoreCase("black") || color.equalsIgnoreCase("черный")) {
            defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text("Черный")).click();
        } else if (color.equalsIgnoreCase("blue") || color.equalsIgnoreCase("синий")) {
            defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text("Синий")).click();
        } else if (color.equalsIgnoreCase("pink") || color.equalsIgnoreCase("розовый")) {
            defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text("Розовый")).click();
        } else if (color.equalsIgnoreCase("white") || color.equalsIgnoreCase("белый")) {
            defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text("Белый")).click();
        } else {
            fail("Use grey, red, black, blue, white or pink color");
        }
    }

    @DisplayName("Фильтр - сортировка по размеру")
    public void chooseSize(String size) {
        if (size.equalsIgnoreCase("S")) {
            defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text("S")).click();
        } else if (size.equalsIgnoreCase("M")) {
            defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text("M")).click();
        } else if (size.equalsIgnoreCase("L")) {
            defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text("L")).click();
        } else if (size.equalsIgnoreCase("XL")) {
            defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text("XL")).click();
        } else {
            fail("Use S, M, L or XL size");
        }
    }

    @Step("Фильтр - показать ещё варианты")
    public void getMoreOptions() {
        defaultCategoryItemPage.getFilterValueMoreButtons().forEach(SelenideElement::click);
    }

    @Step("Фильтр -  сортировка по бренду")
    public void chooseBrand(String brand) {
        if (brand.equalsIgnoreCase("New Balance")) {
            defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text("New Balance")).click();
        } else if (brand.equalsIgnoreCase("Lacoste")) {
            defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text("Lacoste")).click();
        } else if (brand.equalsIgnoreCase("Adidas")) {
            defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text("adidas")).click();
        } else if (brand.equalsIgnoreCase("Nike")) {
            defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text("Nike")).click();
        } else if (brand.equalsIgnoreCase("Puma")) {
            defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text("PUMA")).click();
        } else if (brand.equalsIgnoreCase("Reebok")) {
            defaultCategoryItemPage.getFilterValueItemsCheckbox().findBy(Condition.text("Reebok")).click();
        } else {
            fail("Use New Balance, Lacoste, Adidas, Nike, or Puma brand");
        }
    }

}
