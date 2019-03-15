package Final.steps;

import Final.pages.LogoutPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class LogoutSteps {

    LogoutPage logoutPage;

    @Step
    public void click_currentAccountBlock() {
        logoutPage.click_curentAccountBlock();
    }

    @Step
    public void click_signOutButton(String value) {
        logoutPage.click_signOut(value);
    }

}
