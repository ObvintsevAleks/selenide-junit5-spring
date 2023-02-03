package autotest.ui.navisale.page;

import autotest.ui.navisale.page.main.Footer;
import autotest.ui.navisale.page.main.Header;
import autotest.ui.navisale.page.main.ItemAddWindow;
import autotest.ui.navisale.page.main.Widget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public  class BasePage {

    @Autowired
    protected BasketPage basketPage;
    @Autowired
    protected DefaultCategoryItemPage defaultCategoryItemPage;
    @Autowired
    protected DefaultItemPage defaultItemPage;
    @Autowired
    protected FavoritesPage favoritesPage;
    @Autowired
    protected MainPage mainPage;
    @Autowired
    protected NewOrderPage newOrderPage;
    @Autowired
    protected Footer footer;
    @Autowired
    protected Header header;
    @Autowired
    protected Widget widget;
    @Autowired
    protected ItemAddWindow itemAddWindow;

}
