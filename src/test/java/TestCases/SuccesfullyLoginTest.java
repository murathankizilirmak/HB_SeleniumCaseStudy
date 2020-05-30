package TestCases;

import Pages.LoginPage;

public class SuccesfullyLoginTest extends LoginPage {
    public static void main(String[] args) {
        OpenPortal("Chrome");
        EnterYourCorrectInfo("simuzumadd-6183@yopmail.com","Test1!");
    }
}


