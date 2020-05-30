package TestCases;

import Pages.LoginPage;

import static Pages.BasketPage.ClickDateFromList;
import static Pages.MainPage.ClickRandomElement;

public class AddToBasket extends LoginPage {
    public static void main(String[] args) {
        OpenPortal("Chrome");
        EnterYourCorrectInfo("simuzumadd-6183@yopmail.com","Test1!");
        ClickRandomElement();
        ClickDateFromList();

    }


}