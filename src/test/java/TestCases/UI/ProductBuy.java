package TestCases.UI;

import Pages.LoginPage;
import Pages.SearchListingPage;
import static Pages.BasketPage.ClickAddToBasket;
import static Pages.BasketPage.ClickToGotoBasket;
import static Pages.MainPage.Search;
import static Pages.SearchListingPage.ClickToProduct;
import static Pages.ShipmentTemplatePage.ClickToContinueButtonOnShipmentPage;

public class ProductBuy extends LoginPage {
    public static void main(String[] args) {
        OpenPortal("Chrome");
        EnterYourCorrectInfo("uyassoora.syr99v@kinikgunebakan.com", "Hburada1");
        Search();
        ClickToProduct();
        ClickAddToBasket();
        ClickToGotoBasket();
        ClickToContinueButtonOnShipmentPage();
    }


}