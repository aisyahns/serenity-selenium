package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Steps;
import starter.pages.HomePage;
import starter.pages.LoginPage;

public class LoginSteps {

    @Steps
    LoginPage loginPage;

    @Steps
    HomePage homePage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.openUrl();
        loginPage.validateOnLoginPage();
    }

    @When("I input valid username")
    public void iInputValidUsername() {
        loginPage.inputUsername("standard_user");
    }

    @And("I input valid password")
    public void iInputValidPassword() {
        loginPage.inputPassword("secret_sauce");
    }

    @And("click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I go to home page")
    public void iGoToHomePage() {
        homePage.headerAppears();
        homePage.headerTextEqual();
        homePage.clickProductName();
    }

    @When("I input protected username")
    public void iInputProtectedUsername() {
        loginPage.inputUsername("locked_out_user");
    }

    @Then("error message {string}")
    public void errorMessage(String arg0) {
        loginPage.errorMessageAppears();
        loginPage.errorMessageEquals(arg0);
    }

    @When("I input {string} username")
    public void iInputUsername(String username) {
        loginPage.inputUsername(username);
    }

    @And("I input {string} password")
    public void iInputPassword(String password) {
        loginPage.inputPassword(password);
    }

    @Then("I get the {string}")
    public void iGetThe(String result) {
        if(result.equals("home page")){
            homePage.headerAppears();
            homePage.headerTextEqual();
        } else {
            loginPage.errorMessageAppears();
            loginPage.errorMessageEquals(result);
        }
    }
}
