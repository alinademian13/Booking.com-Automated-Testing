package Final.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://account.booking.com/")
public class LoginPage extends PageObject {

    @FindBy(id = "login_name_sign_in")
    private WebElementFacade emailAddressField;

    @FindBy(className = "bui-button")
    private WebElementFacade nextButton;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(className = "bui-button")
    private WebElementFacade signInButton;


    public void enter_emailAddress(String emailAddress) {
        emailAddressField.type(emailAddress);
    }

    public void click_nextButton(String value){
        click_element_by_attribute_value(nextButton, value);
    }

    public void enter_password(String password) { passwordField.type(password);
    }

    public void click_signInButton(String value) {
        click_element_by_attribute_value(signInButton, value);
    }

    private void click_element_by_attribute_value(WebElementFacade el, String value) {
        List<WebElement> list = el.findElements(By.tagName("span"));

        for (int i = 0; i < list.size(); i++) {
            String dir = list.get(i).getText();
            if (dir.equalsIgnoreCase(value)) {
                list.get(i).click();
                break;
            }
        }
    }


    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("body"));
        return definitionList.findElements(By.tagName("div")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }
}
