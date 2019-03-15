package Final.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LogoutPage extends PageObject {

//    @FindBy(id = "current_account")
    @FindBy(className = "user_name_block")
    private WebElementFacade currentAccountBlock;

    @FindBy(className = "profile-menu__item--signout ")
    private WebElementFacade signOutButton;


    public void click_curentAccountBlock() {
        currentAccountBlock.click();
    }

    public void click_signOut(String value){
        click_element_by_attribute_value(signOutButton,"value", value);
    }

    private void click_element_by_attribute_value(WebElementFacade el, String attribute, String value) {
        List<WebElement> list = el.findElements(By.tagName("input"));

        for (WebElement item : list) {
            String dir = item.getAttribute(attribute);

            if (dir.equalsIgnoreCase(value)) {
                item.click();
                break;
            }
        }
    }

}
