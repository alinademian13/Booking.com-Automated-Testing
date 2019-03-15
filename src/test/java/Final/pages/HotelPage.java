package Final.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;


public class HotelPage extends PageObject {

    @FindBy(id = "photo_wrapper")
    private WebElementFacade photos;

    @FindBy(className = "bh-photo-modal-close-cross")
    private WebElementFacade closePhotos;

    @FindBy(className = "hprt-nos-select")
    private WebElementFacade selectRoom;

    @FindBy(className = "js-reservation-button")
    private WebElementFacade reserveButton;

    @FindBy(className = "fe_banner__message ")
    private WebElementFacade message;

    public void click_photo() {
        photos.click();
    }

    public void close_photos() {
        closePhotos.click();
    }

    public void choose_room(String nrRooms) {
        selectRoom.selectByValue(nrRooms);
    }

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("div"));
        return definitionList.findElements(By.tagName("strong")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }

//    public void click_reserveButton(String text) {
//        click_element_by_attribute_value(reserveButton, text);
//    }


//    private void click_element_by_attribute_value(WebElementFacade el, String text) {
//        List<WebElement> list = el.findElements(By.tagName("button"));
//
//        for (int i = 0; i < list.size(); i++) {
//            String txt = list.get(i).getText();
//            if (txt.equalsIgnoreCase(text)) {
//                list.get(i).click();
//                break;
//            }
//        }
//    }



}
