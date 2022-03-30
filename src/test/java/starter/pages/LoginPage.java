package starter.pages;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.actions.Scroll.to;

public class LoginPage extends PageObject {

    private By usernameField(){
        return By.id("user-name");
    }

    private By passwordField(){
//        driver.manage().window().maximize();
        return By.id("password");
    }

    private By loginButton(){
        return By.id("login-button");
    } //defini identifier element yang akan berinteraksi dengan automatenya

    private By errorMessage(){
        return By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    }

    @Step
    public void openUrl(){
//        openAt("/books");
        open();
    }

    @Step
    public boolean validateOnLoginPage(){
        return $(loginButton()).isDisplayed();
    }

    @Step
    public void inputUsername(String username){
        $(usernameField()).type(username);
    }

    @Step
    public void inputPassword(String password){
        $(passwordField()).type(password);
    }

    @Step
    public void clickLoginButton(){
        to(loginButton());
        $(loginButton()).click();
    }

    @Step
    public boolean errorMessageAppears(){
        return $(errorMessage()).isDisplayed();
    }

    @Step
    public boolean errorMessageEquals(String text){
        return $(errorMessage()).getText().equals(text);
    }

}
