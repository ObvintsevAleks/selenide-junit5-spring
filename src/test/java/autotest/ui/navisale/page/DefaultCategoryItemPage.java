package autotest.ui.navisale.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
@Component
public class DefaultCategoryItemPage {

    ElementsCollection goToSubcolletionsItemsButton = $$x("//span[@class='subcollection_card-thumb-item']");
    ElementsCollection itemsCollectionButton = $$x("//a[@class='product_card-thumb product_card-thumb--1x1 product_card-thumb--contain']");
    SelenideElement loadPaginationButton = $x("//li[@class='pagination-load']");
    SelenideElement previousPageButton = $x("//li[@class='pagination-item pagination-item-prev']");
    SelenideElement nextPageButton = $x("//li[@class='pagination-item pagination-item-next']");
    ElementsCollection goToPageButtons = $$x("//li[@class='pagination-item']//a");
    SelenideElement changeSortItemBurgerButton = $x("//select[@class='js-filter-sort input--sort']");
    ElementsCollection chooseSortItemsOption = $$x("//select[@class='js-filter-sort input--sort']//option"); //после идет ajax
    SelenideElement filterForm = $x("//div[@class='filter js-filter']");
    SelenideElement upPriceSlider = $x("//span[@class='irs-slider from']");
    SelenideElement cutPriceSlider = $x("//span[@class='irs-slider to type_last']");
    ElementsCollection filterValueItemsCheckbox = $$x("//li[@class='filter-value js-filter-value']");
    ElementsCollection filterValueMoreButtons = $$x("//li[@class='filter-value filter-value-more']");





}

