package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.actions.Scroll.to;

public class HomePage extends PageObject {

    private By productHeader(){
        return By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    }

    private By productName(){
        return By.xpath("//div[text() = 'Sauce Labs Onesie']");
    }

    @Step
    public void clickProductName(){
        to(productName());
        $(productName()).click();
    }

    @Step
    public boolean headerAppears(){
        return $(productHeader()).isDisplayed();
    }

    @Step
    public boolean headerTextEqual(){
        return $(productHeader()).getText().equals("Products");
    }
}
