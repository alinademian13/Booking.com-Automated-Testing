package Final.features.valid;

import Final.steps.LoginSteps;
import Final.steps.LogoutSteps;
import Final.steps.SearchSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src\\test\\resources\\validSearchData.csv")
public class SearchParametrizedTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public SearchSteps searchSteps;


    String emailAddres, nextButton, password, signInButton,
            destination, checkInDate, checkOutDate, nrRooms, nrPersons, searchButton;

    @Test
    public void valid_login_logout() throws InterruptedException {

        loginSteps.go_to_login_page();

        loginSteps.enter_emailAddress(emailAddres);
        loginSteps.click_nextButton(nextButton);
        loginSteps.enter_password(password);
        loginSteps.click_signInButton(signInButton);

        Thread.sleep(2000);

        searchSteps.enter_destination(destination);
        searchSteps.click_checkInField();
        searchSteps.click_nextMonth();
        searchSteps.chooseCheckInDate(checkInDate);
        searchSteps.chooseCheckOutDate(checkOutDate);
        searchSteps.click_roomsAndPersons();

        searchSteps.choose_nrRooms(nrRooms);

        searchSteps.choose_nrPersons(nrPersons);

        searchSteps.click_searchButton(searchButton);

        Thread.sleep(2000);

    }
}
