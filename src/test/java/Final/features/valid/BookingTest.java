package Final.features.valid;

import Final.steps.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class BookingTest {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public LogoutSteps logoutSteps;

    @Steps
    public SearchSteps searchSteps;

    @Steps
    public FilterSteps filterSteps;

    @Steps
    public HotelSteps hotelSteps;

    @Test
    public void login() throws InterruptedException {
        loginSteps.go_to_login_page();

        loginSteps.enter_emailAddress("emaildetest1@yahoo.com");
        loginSteps.click_nextButton("Next");
        loginSteps.enter_password("paroladetest1");
        loginSteps.click_signInButton("Sign in");

        Thread.sleep(1000);

        searchSteps.enter_destination("Paris");
        searchSteps.click_checkInField();
        searchSteps.click_nextMonth();
        searchSteps.chooseCheckInDate("18");
        searchSteps.chooseCheckOutDate("22");
        searchSteps.click_roomsAndPersons();


        // ============================= + - BUTTONS ===========================
//        searchSteps.choose_camere("+");
//        searchSteps.choose_persoane();

        // ============================== SELECT OPTION =======================
//        searchSteps.click_nrRooms();
        searchSteps.choose_nrRooms("2");
//        searchSteps.click_nrPersons();
        searchSteps.choose_nrPersons("4");

        searchSteps.click_searchButton("Search");

        Thread.sleep(2000);

        String review = "9";

        filterSteps.choose_reviewScore(review);
        Thread.sleep(1000);
        filterSteps.choose_starRating("5 stars");

        Thread.sleep(3000);

        filterSteps.check_reviewScore_in_listOfHotels(review);

        Thread.sleep(3000);

        filterSteps.choose_hotel("Hotel");

        hotelSteps.click_photo();
        hotelSteps.close_photos();

        Thread.sleep(2000);

        hotelSteps.choose_room("2");

//        hotelSteps.click_reserveButton("I'll reserve");
//        hotelSteps.should_see_message("Great choice! You're almost done, Nume.");

        Thread.sleep(7000);

        logoutSteps.click_currentAccountBlock();

        Thread.sleep(1000);

        logoutSteps.click_signOutButton("Sign Out");

        Thread.sleep(1000);

    }
}
