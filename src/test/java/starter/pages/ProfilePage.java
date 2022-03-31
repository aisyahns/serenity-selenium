package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class ProfilePage extends PageObject {

    private By headerProfile(){
        return By.className("main-header");
    }

    @Step
    public boolean validateHeaderProfileAppears(){
        return $(headerProfile()).isDisplayed();
    }

    @Step
    public boolean validateHeaderProfileEqual(String text){
        return $(headerProfile()).getText().equals(text);
    }
}
