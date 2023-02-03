package autotest.ui.navisale.config;

import autotest.ui.navisale.page.*;
import autotest.ui.navisale.page.main.Footer;
import autotest.ui.navisale.page.main.Header;
import autotest.ui.navisale.page.main.Widget;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "autotest.ui.navisale"
})
@EnableConfigurationProperties
public class SpringConfig {

    @Bean
    public BasketPage basketPage() {
        return new BasketPage();
    }

    @Bean
    public DefaultCategoryItemPage defaultCategoryItemPage() {
        return new DefaultCategoryItemPage();
    }

    @Bean
    public DefaultItemPage defaultItemPage() {
        return new DefaultItemPage();
    }

    @Bean
    public FavoritesPage favoritesPage() {
        return new FavoritesPage();
    }

    @Bean
    public MainPage mainPage() {
        return new MainPage();
    }

    @Bean
    public NewOrderPage newOrderPage() {
        return new NewOrderPage();
    }

    @Bean
    public Footer footer() {
        return new Footer();
    }

    @Bean
    public Header header() {
        return new Header();
    }

    @Bean
    public Widget widget() {
        return new Widget();
    }

}
