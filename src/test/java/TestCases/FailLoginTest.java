package TestCases;

import Pages.LoginPage;

public class FailLoginTest extends LoginPage {
    public static void main(String[] args) {
        OpenPortal("Chrome");
        EnterYourWrongCredentials("simuzumadd-6183@yopmail.coma","Test1!");

    }
}
