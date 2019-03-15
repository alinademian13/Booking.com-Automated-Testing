package Final.features.valid;

import Final.steps.*;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src\\test\\resources\\validLoginLogoutData.csv")
public class LoginLogoutParametrizedTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public LogoutSteps logoutSteps;

    String emailAddres, nextButton, password, signInButton, signOutButton;

    @Test
    public void valid_login_logout() throws InterruptedException {

        loginSteps.go_to_login_page();

        loginSteps.enter_emailAddress(emailAddres);
        loginSteps.click_nextButton(nextButton);
        loginSteps.enter_password(password);
        loginSteps.click_signInButton(signInButton);

        Thread.sleep(2000);

        logoutSteps.click_currentAccountBlock();

        Thread.sleep(1000);

        logoutSteps.click_signOutButton(signOutButton);
    }
}
