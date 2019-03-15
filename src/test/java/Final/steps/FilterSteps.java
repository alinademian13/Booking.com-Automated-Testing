package Final.steps;

import Final.pages.FilterPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FilterSteps {

    FilterPage filterPage;

    @Step
    public void choose_reviewScore(String review) {
        filterPage.choose_reviewScore(review);
    }

    @Step
    public void choose_starRating(String star) {
        filterPage.choose_starRating(star);
    }

    @Step
    public void choose_hotel(String name) {
        filterPage.choose_hotel(name);
    }

    @Step
    public void check_reviewScore_in_listOfHotels(String review) {
        List<Double> reviews = filterPage.getPropertiesReviews();

        assertTrue(reviews.stream().anyMatch(item -> item.compareTo(Double.valueOf(review)) <= 0));
    }
}
