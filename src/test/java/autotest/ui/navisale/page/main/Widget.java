package autotest.ui.navisale.page.main;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$x;

@Getter
@Component
public class Widget {

    SelenideElement catalogForm = $x("//nav[@class='nav-collections nav-collections--dropdown js-nav-collections js-nav-collections-trigger js-clone']");
    SelenideElement catalogWidgetButton = $x("//a[@class='hamburger-trigger js-nav-collections-trigger']");
    SelenideElement bootsCategoryButton = $x("//li[@data-collection-id='22027953']");
    SelenideElement bootsForManButton = $x("//li[@data-collection-id='22052630']");
    SelenideElement manShoesForSportButton = $x("//li[@data-collection-id='22055646']");
    SelenideElement manKicksButton = $x("//li[@data-collection-id='22144946']");
    SelenideElement bootsForWomanButton = $x("//li[@data-collection-id='22052632']");
    SelenideElement womanSneakersButton = $x("//li[@data-collection-id='22054224']");
    SelenideElement womanKicksButton = $x("//li[@data-collection-id='22145722']");
    SelenideElement clothesCategoryButton = $x("//li[@data-collection-id='22067158']");
    SelenideElement manClothesButton = $x("//li[@data-collection-id='22067160']");
    SelenideElement manTShirtsButton = $x("//li[@data-collection-id='22067165']");
    SelenideElement manHoodiesButton = $x("//li[@data-collection-id='22146730']");
    SelenideElement manJacketsButton = $x("//li[@data-collection-id='22158209']");
    SelenideElement womanClothesButton = $x("//li[@data-collection-id='22075501']");
    SelenideElement womanTShirtButton = $x("//li[@data-collection-id='22562787']");
    SelenideElement womanHoodiesButton = $x("//li[@data-collection-id='22562792']");
    SelenideElement womanJacketsButton = $x("//li[@data-collection-id='22562796']");
    SelenideElement bagsAndBackpackCategoryButton = $x("//li[@data-collection-id='22062080']");
    SelenideElement backpackButton = $x("//li[@data-collection-id='22062091']");
    SelenideElement sportBackpackButton = $x("//li[@data-collection-id='22063384']");
    SelenideElement cityBackpackButton = $x("//li[@data-collection-id='22063386']");
    SelenideElement bagsButton = $x("//li[@data-collection-id='22063923']");
    SelenideElement beltBagsButton = $x("//li[@data-collection-id='22063925']");
    SelenideElement shoulderBagsButton = $x("//li[@data-collection-id='22064717']");
    SelenideElement sportBagsButton = $x("//li[@data-collection-id='22064878']");
    SelenideElement accessoryCategoryButton = $x("//li[@data-collection-id='22065292']");
    SelenideElement headgearButton = $x("//li[@data-collection-id='22066664']");
    SelenideElement baseballCapsButton = $x("//li[@data-collection-id='22066666']");
    SelenideElement sunglassesButton = $x("//li[@data-collection-id='22081738']");
    SelenideElement manSunglassesButton = $x("//li[@data-collection-id='22081744']");
    SelenideElement womanSunglassesButton = $x("//li[@data-collection-id='22162316']");


}
