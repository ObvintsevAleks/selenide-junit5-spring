package autotest.ui.navisale.steps;

import autotest.ui.navisale.page.DefaultCategoryItemPage;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;

@Component
public class DefaultCategoryItemSteps {

    @Autowired
    private DefaultCategoryItemPage defaultCategoryItemPage;

    public void loadNewItemsInPage() {
        defaultCategoryItemPage.getLoadPaginationButton().shouldBe(visible).click();
    }

    public void goToNextPage() {
        defaultCategoryItemPage.getNextPageButton().shouldBe(visible).click();
    }

    public void goToPreviousPage() {
        defaultCategoryItemPage.getPreviousPageButton().shouldBe(visible).click();
    }

    public void chooseSortTypeByTitle() {
        defaultCategoryItemPage.getChangeSortItemBurgerButton().shouldBe(visible).click();
        defaultCategoryItemPage.getChooseSortItemsOption().filter(value("title")).get(0).click();
    }

    @Step("Сортировка товаров по скидке - категория товаров")
    public void chooseSortTypeByDiscount() {
        defaultCategoryItemPage.getChangeSortItemBurgerButton().click();
        defaultCategoryItemPage.getChooseSortItemsOption().filter(value("descending_discount")).get(0).click();
        defaultCategoryItemPage.getChangeSortItemBurgerButton().click();
    }

    @Step("Сортировка товаров по популярности - категория товаров")
    public void chooseSortTypeByPopulatiy() {
        defaultCategoryItemPage.getChangeSortItemBurgerButton().shouldBe(visible).click();
        defaultCategoryItemPage.getChooseSortItemsOption().filter(value("descending_popularity")).get(0).click();
        defaultCategoryItemPage.getChangeSortItemBurgerButton().click();
    }

    @Step("Сортировка товаров по низкой цене - категория товаров")
    public void chooseSortTypeByLowPriceFirst() {
        defaultCategoryItemPage.getChangeSortItemBurgerButton().shouldBe(visible).click();
        defaultCategoryItemPage.getChooseSortItemsOption().filter(value("price")).get(0).click();
        defaultCategoryItemPage.getChangeSortItemBurgerButton().shouldBe(visible).click();
    }

    @Step("Сортировка товаров по высокой цене - категория товаров")
    public void chooseSortTypeByHighPriceFirst() {
        defaultCategoryItemPage.getChangeSortItemBurgerButton().shouldBe(visible).click();
        defaultCategoryItemPage.getChooseSortItemsOption().filter(value("descending_price")).get(0).click();
        defaultCategoryItemPage.getChangeSortItemBurgerButton().shouldBe(visible).click();
    }

    @Step("Сортировка товаров по новинкам - категория товаров")
    public void chooseSortTypeByAgeItems() {
        defaultCategoryItemPage.getChangeSortItemBurgerButton().shouldBe(visible).click();
        defaultCategoryItemPage.getChooseSortItemsOption().filter(value("descending_age")).get(0).click();
        defaultCategoryItemPage.getChangeSortItemBurgerButton().shouldBe(visible).click();
    }

    @Step("Переход в подкатегорию - категория товаров")
    public void goToSubcategory() {
        defaultCategoryItemPage.getGoToSubcolletionsItemsButton().get(0).click();
    }

    @Step("Переход на страницу первого товара - категория товаров")
    public void getFirstItem() {
        defaultCategoryItemPage.getItemsCollectionButton().get(0).click();
    }

    public void sortItemsByFilter() {

    }

}
