package Final.steps;

import Final.pages.HotelPage;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class HotelSteps {

    HotelPage hotelPage;

    @Step
    public void click_photo() {
        hotelPage.click_photo();
    }

    @Step
    public void close_photos() {
        hotelPage.close_photos();
    }

    @Step
    public void choose_room(String nrRooms) {
        hotelPage.choose_room(nrRooms);
    }
//
//    @Step
//    public void click_reserveButton(String text) {
//        hotelPage.click_reserveButton(text);
//    }
//
//    @Step
//    public void should_see_message(String message) {
//        assertThat(hotelPage.getDefinitions(), hasItem(containsString(message)));
//    }
}
