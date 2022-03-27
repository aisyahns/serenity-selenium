package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class HomePage extends PageObject {

    private By productHeader(){
        return By.xpath("//*[@id=\"header_container\"]/div[2]/span");
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
