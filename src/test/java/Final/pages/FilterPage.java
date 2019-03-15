package Final.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;

public class FilterPage extends PageObject {

    @FindBy(className = "hotel_name_link url")
    private WebElementFacade link;

    @FindBy(id = "filter_review")
    private WebElementFacade reviews;

    @FindBy(id = "hotellist_inner")
    private WebElementFacade allHotels;

    @FindBy(id="filter_class")
    private WebElementFacade stars;



    public void choose_reviewScore(String review) {
        click_element_by_attribute_value(reviews, review);
    }

    public void choose_starRating(String star) {
        click_element_by_attribute_value(stars, star);
    }

    public void choose_hotel(String name) {
        click_link_by_attribute_value(allHotels, name);
    }


    private void click_link_by_attribute_value(WebElementFacade el, String filterItem) {
        List<WebElement> list = el.findElements(By.className("hotel_name_link"));

        for (WebElement element : list) {
            WebElement spanEl = element.findElement(By.tagName("span"));

            if (spanEl.getText().contains(filterItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();

                jsExecutor.executeScript("arguments[0].setAttribute('target', '_self')", element);

                element.click();

                break;
            }
        }
    }

    private void click_element_by_attribute_value(WebElementFacade el, String filterItem) {
        List<WebElement> list = el.findElements(By.tagName("span"));

        for (int i = 0; i < list.size(); i++) {
            String items = list.get(i).getText();
            if (items.contains(filterItem)) {

                list.get(i).click();
                break;
            }
        }
    }

    public List<Double> getPropertiesReviews() {
        List<Double> reviews = new ArrayList<>();

        List<WebElement> propertyElems = allHotels.findElements(By.cssSelector("div.sr_item.sr_property_block"));

        for (WebElement propertyElem : propertyElems) {
            WebElement reviewEl = propertyElem.findElement(By.className("bui-review-score__badge"));

            Double review = Double.valueOf(reviewEl.getText());

            System.out.println(review);

            reviews.add(review);
        }

        return reviews;
    }
}
