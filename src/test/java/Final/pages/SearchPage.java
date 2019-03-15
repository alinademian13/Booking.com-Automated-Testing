package Final.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.booking.com/")
public class SearchPage extends PageObject {


    @FindBy(id = "ss")
    private WebElementFacade destinationField;

    @FindBy(className = "xp__dates__checkin")
    private WebElementFacade checkInField;

    @FindBy(className = "bui-calendar__control--next")
    private WebElementFacade nextMonth;

    @FindBy(className = "bui-calendar__wrapper")
    private WebElementFacade dates;

    @FindBy(id = "xp__guests__toggle")
    private WebElementFacade roomsAndPersons;

    @FindBy(id = "no_rooms")
    private WebElementFacade rooms;

    @FindBy(id = "group_adults")
    private WebElementFacade persons;

    @FindBy(className = "xp__button")
    private WebElementFacade searchButton;

//    @FindBy(className = "sb-group__field-rooms")
//    private WebElementFacade camere;
//
//    @FindBy(xpath = "//div[@class=\"sb-group__field\"]/button[@class=\"bui-button bui-button--secondary bui-stepper__add-button\"]")
//    private WebElementFacade plusPersonsButton;

//    @FindBy(xpath = "//div[@class=\"sb-group__field\"][2]")
//    private WebElementFacade persoane;


    public void enter_destinationField(String destination) {
        destinationField.type(destination);
    }

    public void click_checkInField() {
        checkInField.click();
    }

    public void click_nextMonth() {
        nextMonth.click();
    }

    public void chooseCheckInDate(String checkInDate) {
        click_element_by_attribute_value(dates, checkInDate);
    }

    public void chooseCheckOutDate(String checkOutDate) {
        click_element_by_attribute_value(dates, checkOutDate);
    }

    public void click_roomsAndPersons() {
        roomsAndPersons.click();
    }


    private boolean canSelectDropdowns() {
        WebElementFacade inputStepper = findBy("//div[@data-bui-component=\"InputStepper\"]");

        return !inputStepper.isPresent();
    }

    public void choose_nrRooms(String nrRooms) {
        if (this.canSelectDropdowns()) {
            rooms.selectByValue(nrRooms);
        }
    }

    public void choose_nrPersons(String nrPersons) {
        if (this.canSelectDropdowns()) {
            persons.selectByValue(nrPersons);
        }
    }

    // ============================ SEARCH =================================


    public void click_searchButton(String text) {
        click_element_by_attribute_valuess(searchButton, text);
    }

    private void click_element_by_attribute_value(WebElementFacade el, String date) {
        List<WebElement> listOfDates = el.findElements(By.tagName("td"));

        for (int i = 0; i < listOfDates.size(); i++) {
            String dates = listOfDates.get(i).getText();
            if (dates.equalsIgnoreCase(date)) {
                listOfDates.get(i).click();
                break;
            }
        }
    }

    private void click_element_by_attribute_valuess(WebElementFacade el, String text) {
        List<WebElement> list = el.findElements(By.tagName("span"));

        for (int i = 0; i < list.size(); i++) {
            String txt = list.get(i).getText();
            if (txt.equalsIgnoreCase(text)) {
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

    // ============================= + - BUTTONS ===========================
//
//    public void choose_camere(String text) {
//        click_element_by_attribute_valuess(camere, text);
//    }
//
////    public void choose_persoane(String text) {
////        click_element_by_attribute_valuess(persoane, text);
////    }
//
//    public void choose_persoane() {
//        plusPersonsButton.click();
//    }
}
