package Final.features.invalid;

import Final.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    public LoginSteps loginSteps;

    @Test
    public void login() {
        loginSteps.go_to_login_page();

        loginSteps.enter_emailAddress("emaildetest@yahoo.com");
        loginSteps.click_nextButton("Next");
        loginSteps.should_see_message("Looks like there isn't an account associated with this email address. You can create an account to access our services.");

        loginSteps.enter_emailAddress("emaildetest1@yahoo.com");
        loginSteps.click_nextButton("Next");
        loginSteps.enter_password("paroladetest");
        loginSteps.click_signInButton("Sign in");
        loginSteps.should_see_message("The email and password combination you entered doesn't match.");


    }
}
