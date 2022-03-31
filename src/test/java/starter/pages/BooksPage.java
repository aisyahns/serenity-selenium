package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class BooksPage extends PageObject {

    private By loginButton(){
        return By.id("login");
    }

    private By searchField(){
        return By.id("searchBox");
    }

    @Step
    public void openUrl(){
        openAt("/books");
    }

    @Step
    public void clickLoginButton(){
        $(loginButton()).click();
    }

    @Step
    public boolean validateBooksPage(){
        return $(searchField()).isDisplayed();
    }
}
