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

    ElementsCollection goToSubcolletionsItemsButton = $$x("//span[@class='subcollection_card-thumb-item']"),
            itemsCollectionButton = $$x("//a[@class='product_card-thumb product_card-thumb--1x1 product_card-thumb--contain']"),
            goToPageButtons = $$x("//li[@class='pagination-item']//a"),
            chooseSortItemsOption = $$x("//select[@class='js-filter-sort input--sort']//option"),
            filterValueItemsCheckbox = $$x("//li[@class='filter-value js-filter-value']"),
            filterValueMoreButtons = $$x("//li[@class='filter-value filter-value-more']");

    SelenideElement loadPaginationButton = $x("//li[@class='pagination-load']"),
            previousPageButton = $x("//li[@class='pagination-item pagination-item-prev']"),
            nextPageButton = $x("//li[@class='pagination-item pagination-item-next']"),
            changeSortItemBurgerButton = $x("//select[@class='js-filter-sort input--sort']"),
            filterForm = $x("//div[@class='filter js-filter']"),
            upPriceSlider = $x("//span[@class='irs-slider from']"),
            cutPriceSlider = $x("//span[@class='irs-slider to type_last']");


}

