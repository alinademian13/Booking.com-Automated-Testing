package Final.steps;

import Final.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class LoginSteps {

    LoginPage loginPage;

    @Step
    public void enter_emailAddress(String emailAddress) {
        loginPage.enter_emailAddress(emailAddress);
    }

    @Step
    public void click_nextButton(String value) {
        loginPage.click_nextButton(value);
    }

    @Step
    public void enter_password(String password) {
        loginPage.enter_password(password);
    }

    @Step
    public void click_signInButton(String value) {
        loginPage.click_signInButton(value);
    }

    @Step
    public void go_to_login_page() {
        loginPage.open();
    }

    @Step
    public void should_see_message(String message) {
        assertThat(loginPage.getDefinitions(), hasItem(containsString(message)));
    }

    @StepGroup
    public void login_steps(String emailAddress, String value, String password, String value2) {
        enter_emailAddress(emailAddress);
        click_nextButton(value);
        enter_password(password);
        click_signInButton(value2);
    }
}
