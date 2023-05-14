package autotest.ui.navisale.steps.main;

import autotest.ui.navisale.page.main.Widget;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@Component
public class WidgetSteps {

    @Autowired
    private Widget widget;


    public void goToCatalogue() {
        widget.getCatalogWidgetButton().hover();
        sleep(150);
    }

    @Step("Переход по категории: Обувь -> Для него")
    public void goToMansBootsCategory() {
        goToCatalogue();
        widget.getBootsCategoryButton().hover();
        sleep(100);
        widget.getBootsForManButton().click();
    }

    @Step("Переход по категории: Обувь -> Для него -> Обувь для спорта")
    public void goToManShoesForSportCategory() {
        goToCatalogue();
        widget.getBootsCategoryButton().hover();
        sleep(100);
        widget.getBootsForManButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/obuv-dlya-sporta-2", widget.getManShoesForSportButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getManShoesForSportButton().click();
    }

    @Step("Переход по категории: Обувь -> Для него -> Кеды")
    public void goToManKicksCategory() {
        goToCatalogue();
        widget.getBootsCategoryButton().hover();
        sleep(100);
        widget.getBootsForManButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/kedy", widget.getManKicksButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getManKicksButton().click();
    }

    @Step("Переход по категории: Обувь -> Для неё -> Кроссовки")
    public void goWomanSneakersCategory() {
        goToCatalogue();
        widget.getBootsCategoryButton().hover();
        sleep(100);
        widget.getBootsForWomanButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/krossovki-2", widget.getWomanSneakersButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getWomanSneakersButton().click();
    }

    @Step("Переход по категории: Обувь -> Для неё -> Кеды")
    public void goWomanKicksCategory() {
        goToCatalogue();
        widget.getBootsCategoryButton().hover();
        sleep(100);
        widget.getBootsForWomanButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/kedy-2", widget.getWomanKicksButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getWomanKicksButton().click();
    }

    @Step("Переход по категории: Одежда -> Для него -> Футболки")
    public void goManTShirtsCategory() {
        goToCatalogue();
        widget.getClothesCategoryButton().hover();
        sleep(100);
        widget.getManClothesButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/futbolki", widget.getManTShirtsButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getManTShirtsButton().click();
    }

    @Step("Переход по категории: Одежда -> Для него -> Толстовки и свитшоты")
    public void goManHoodiesCategory() {
        goToCatalogue();
        widget.getClothesCategoryButton().hover();
        sleep(100);
        widget.getManClothesButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/tolstovki-i-svitshoty-2", widget.getManHoodiesButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getManHoodiesButton().click();
    }

    @Step("Переход по категории: Одежда -> Для него -> Куртки")
    public void goManJacketsCategory() {
        goToCatalogue();
        widget.getClothesCategoryButton().hover();
        sleep(100);
        widget.getManClothesButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/kurtki", widget.getManJacketsButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getManJacketsButton().click();
    }

    @Step("Переход по категории: Одежда -> Для неё -> Футболки")
    public void goWomanTShirtsCategory() {
        goToCatalogue();
        widget.getClothesCategoryButton().hover();
        sleep(100);
        widget.getWomanClothesButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/futbolki-2", widget.getWomanTShirtButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getWomanTShirtButton().click();
    }

    @Step("Переход по категории: Одежда -> Для неё -> Толстовки и свитшоты")
    public void goWomanHoodiesCategory() {
        goToCatalogue();
        widget.getClothesCategoryButton().hover();
        sleep(100);
        widget.getWomanClothesButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/tolstovki-i-svitshoty", widget.getWomanHoodiesButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getWomanHoodiesButton().click();
    }

    @Step("Переход по категории: Одежда -> Для неё -> Куртки")
    public void goWomanJacketsCategory() {
        goToCatalogue();
        widget.getClothesCategoryButton().hover();
        sleep(100);
        widget.getWomanClothesButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/kurtki-2", widget.getWomanJacketsButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getWomanJacketsButton().click();
    }

    @Step("Переход по категории: Сумки и рюкзаки -> Рюкзаки -> Спортивные")
    public void goSportsBackpackCategory() {
        goToCatalogue();
        widget.getBagsAndBackpackCategoryButton().hover();
        sleep(100);
        widget.getBackpackButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/sportivnye", widget.getSportBackpackButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getSportBackpackButton().click();
    }

    @Step("Переход по категории: Сумки и рюкзаки -> Рюкзаки -> Городские")
    public void goCityBackpackCategory() {
        goToCatalogue();
        widget.getBagsAndBackpackCategoryButton().hover();
        sleep(100);
        widget.getBackpackButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/gorodskie", widget.getCityBackpackButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getCityBackpackButton().click();
    }

    @Step("Переход по категории: Сумки и рюкзаки -> Сумки -> Поясные")
    public void goBeltBagCategory() {
        goToCatalogue();
        widget.getBagsAndBackpackCategoryButton().hover();
        sleep(100);
        widget.getBagsButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/poyasnye", widget.getBeltBagsButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getBeltBagsButton().click();
    }

    @Step("Переход по категории: Сумки и рюкзаки -> Сумки -> Через плечо")
    public void goShoulderBagCategory() {
        goToCatalogue();
        widget.getBagsAndBackpackCategoryButton().hover();
        sleep(100);
        widget.getBagsButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/cherez-plecho", widget.getShoulderBagsButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getShoulderBagsButton().click();
    }

    @Step("Переход по категории: Сумки и рюкзаки -> Сумки -> Спортивные")
    public void goSportBagCategory() {
        goToCatalogue();
        widget.getBagsAndBackpackCategoryButton().hover();
        sleep(100);
        widget.getBagsButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/sportivnye-2", widget.getSportBagsButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getSportBagsButton().click();
    }

    @Step("Переход по категории: Аксессуары -> Головные уборы -> Бейсболки")
    public void goBaseballCapCategory() {
        goToCatalogue();
        widget.getAccessoryCategoryButton().hover();
        sleep(100);
        widget.getHeadgearButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/beysbolki", widget.getBaseballCapsButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getBaseballCapsButton().click();
    }

    @Step("Переход по категории: Аксессуары -> Очки -> Для него")
    public void goManSunglassesCategory() {
        goToCatalogue();
        widget.getAccessoryCategoryButton().hover();
        sleep(100);
        widget.getSunglassesButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/dlya-nego-3", widget.getManSunglassesButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getManSunglassesButton().click();
    }

    @Step("Переход по категории: Аксессуары -> Очки -> Для неё")
    public void goWomanSunglassesCategory() {
        goToCatalogue();
        widget.getAccessoryCategoryButton().hover();
        sleep(100);
        widget.getSunglassesButton().hover();
        sleep(100);
        assertEquals("https://shop.navisale.ru/collection/dlya-neyo-3", widget.getWomanSunglassesButton().lastChild().getAttribute("href")
                , "Неправильное значение параметра href!");
        widget.getWomanSunglassesButton().click();
    }

    @Step("Переход в виджете по всем категориям")
    public void goToAllCategoryFromWidget() {
        goToManShoesForSportCategory();
        goToManKicksCategory();
        goWomanSneakersCategory();
        goWomanKicksCategory();
        goManTShirtsCategory();
        goManHoodiesCategory();
        goManJacketsCategory();
        goWomanTShirtsCategory();
        goWomanHoodiesCategory();
        goWomanJacketsCategory();
        goSportsBackpackCategory();
        goCityBackpackCategory();
        goBeltBagCategory();
        goShoulderBagCategory();
        goSportBagCategory();
        goManSunglassesCategory();
        goWomanSunglassesCategory();
    }

    @Step("Выбираем категорию - {category}")
    public void chooseCategory(String category) {
        switch (category) {
            case "Обувь мужская" -> goToMansBootsCategory();
            case "Обувь мужская спортивная" -> goToManShoesForSportCategory();
            case "Кеды мужские" -> goToManKicksCategory();
            case "Кроссовки женские" -> goWomanSneakersCategory();
            case "Кеды женские" -> goWomanKicksCategory();
            case "Футболки мужские" -> goManTShirtsCategory();
            case "Толстовки мужские" -> goManHoodiesCategory();
            case "Куртки мужские" -> goManJacketsCategory();
            case "Футболки женские" -> goWomanTShirtsCategory();
            case "Толстовки женские" -> goWomanHoodiesCategory();
            case "Куртки женские" -> goWomanJacketsCategory();
            case "Рюкзаки спортивные" -> goSportsBackpackCategory();
            case "Рюкзаки городские" -> goCityBackpackCategory();
            case "Сумки поясные" -> goBeltBagCategory();
            case "Сумки через плечо" -> goShoulderBagCategory();
            case "Сумки спортивные" -> goSportBagCategory();
            case "Бейсболки" -> goBaseballCapCategory();
            case "Очки мужские" -> goManSunglassesCategory();
            case "Очки женские" -> goWomanSunglassesCategory();
            default -> fail("Неправильно выбрана категория");
        }
    }


}
