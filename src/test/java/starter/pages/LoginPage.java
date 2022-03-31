package starter.pages;

//import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.core.pages.SerenityActions;
import net.serenitybdd.screenplay.actions.ScrollToBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends PageObject {


    ScrollToBy scroll = new ScrollToBy();

    private By usernameField(){
        return By.id("userName");
    }

    private By passwordField(){
//        driver.manage().window().maximize();
        return By.id("password");
    }

    private By loginButton(){
        return By.id("login");
    } //defini identifier element yang akan berinteraksi dengan automatenya

    private By errorMessage(){
        return By.id("name");
    }

    private By interactionsText(){
        return By.xpath("//div[text() = 'Interactions']");
    }

    private By iconWarning(){
        return By.xpath("//input[@class='mr-sm-2 is-invalid form-control']");
    }

    @Step
    public boolean verifyIconWarningAppears(){
        return $(iconWarning()).isDisplayed();
    }

    @Step
    public void openUrl(){
        openAt("/books");
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
        $(loginButton()).click();
    }

    @Step
    public void scrollTo(){
        SerenityActions actions = new SerenityActions(getDriver());
        actions.moveToElement($(interactionsText())).perform();
//        getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
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
