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

    @Step("Переход по всем категориям - widget")
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

    public void chooseCategory(String category) {
        if (category.equalsIgnoreCase("Обувь мужская")) {
            goToMansBootsCategory();
        } else if(category.equalsIgnoreCase("Обувь мужская спортивная")) {
            goToManShoesForSportCategory();
        } else if(category.equalsIgnoreCase("Кеды мужские")) {
            goToManKicksCategory();
        } else if(category.equalsIgnoreCase("Кроссовки женские")) {
            goWomanSneakersCategory();
        } else if(category.equalsIgnoreCase("Кеды женские")) {
            goWomanKicksCategory();
        } else if(category.equalsIgnoreCase("Футболки мужские")) {
            goManTShirtsCategory();
        } else if(category.equalsIgnoreCase("Толстовки мужские")) {
            goManHoodiesCategory();
        } else if(category.equalsIgnoreCase("Куртки мужские")) {
            goManJacketsCategory();
        } else if(category.equalsIgnoreCase("Футболки женские")) {
            goWomanTShirtsCategory();
        } else if(category.equalsIgnoreCase("Толстовки женские")) {
            goWomanHoodiesCategory();
        } else if(category.equalsIgnoreCase("Куртки женские")) {
            goWomanJacketsCategory();
        } else if(category.equalsIgnoreCase("Рюкзаки спортивные")) {
            goSportsBackpackCategory();
        } else if(category.equalsIgnoreCase("Рюкзаки городские")) {
            goCityBackpackCategory();
        } else if(category.equalsIgnoreCase("Сумки поясные")) {
            goBeltBagCategory();
        } else if(category.equalsIgnoreCase("Сумки через плечо")) {
            goShoulderBagCategory();
        } else if(category.equalsIgnoreCase("Сумки спортивные")) {
            goSportBagCategory();
        } else if(category.equalsIgnoreCase("Бейсболки")) {
            goBaseballCapCategory();
        } else if(category.equalsIgnoreCase("Очки мужские")) {
            goManSunglassesCategory();
        } else if(category.equalsIgnoreCase("Очки женские")) {
            goWomanSunglassesCategory();
        } else {
            fail();
        }
    }


}
