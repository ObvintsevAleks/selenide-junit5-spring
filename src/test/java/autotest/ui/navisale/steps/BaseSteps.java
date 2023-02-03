package autotest.ui.navisale.steps;

import autotest.ui.navisale.page.BasePage;
import autotest.ui.navisale.steps.main.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseSteps extends BasePage {

    @Autowired
    protected BasketSteps basketSteps;
    @Autowired
    protected DefaultCategoryItemSteps defaultCategoryItemSteps;
    @Autowired
    protected DefaultItemSteps defaultItemSteps;
    @Autowired
    protected FavoritesSteps favoritesSteps;
    @Autowired
    protected MainSteps mainSteps;
    @Autowired
    protected NewOrderSteps newOrderSteps;
    @Autowired
    protected FooterSteps footerSteps;
    @Autowired
    protected HeaderSteps headerSteps;
    @Autowired
    protected WidgetSteps widgetSteps;
    @Autowired
    protected ItemAddWindowSteps itemAddWindowSteps;
    @Autowired
    protected FilterSteps filterSteps;


}
