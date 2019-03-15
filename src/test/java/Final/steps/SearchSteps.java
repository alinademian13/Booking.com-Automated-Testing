package Final.steps;

import Final.pages.SearchPage;
import net.thucydides.core.annotations.Step;

public class SearchSteps {

    SearchPage searchPage;

    @Step
    public void enter_destination(String destination) {
        searchPage.enter_destinationField(destination);
    }

    @Step
    public void click_checkInField() {
        searchPage.click_checkInField();
    }

    @Step
    public void click_nextMonth() {
        searchPage.click_nextMonth();
    }

    @Step
    public void chooseCheckInDate(String checkInDate) {
        searchPage.chooseCheckInDate(checkInDate);
    }

    @Step
    public void chooseCheckOutDate(String checkOutDate) {
        searchPage.chooseCheckOutDate(checkOutDate);
    }

    @Step
    public void click_roomsAndPersons() {
        searchPage.click_roomsAndPersons();
    }

    @Step
    public void choose_nrRooms(String nrRooms) {
        searchPage.choose_nrRooms(nrRooms);
    }

    @Step
    public void choose_nrPersons(String nrPersons) {
        searchPage.choose_nrPersons(nrPersons);
    }

    @Step
    public void click_searchButton(String text) {
        searchPage.click_searchButton(text);
    }

    // ============================= + - BUTTONS ===========================
//    @Step
//    public void choose_camere(String text) {
//        searchPage.choose_camere(text);
//    }
//
////    @Step
////    public void choose_persoane(String text) {
////        searchPage.choose_persoane(text);
////    }
//
//    @Step
//    public void choose_persoane() {
//        searchPage.choose_persoane();
//    }

}
