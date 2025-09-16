package calendar;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java8.Fr;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Steps implements Fr {

//    public Steps() {
//        Et("the day before yesterday is {oldIsoDate}", (Object date) -> {
//
//        });
//    }

    @And("today is {isoDate}")
    public void step_method(LocalDate arg1) {
        System.out.println("text");
    }

    @ParameterType("\\d{4}-\\d{2}-\\d{2}")
    public LocalDate isoDate(String dateStr) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @And("yesterday was {isoDate}, and in {int} days it will be {isoDate}")
    public void step_method_2(LocalDate yesterdayDate, int days, LocalDate futureDate) {
        LocalDate actualFutureDate = yesterdayDate.plusDays(days + 1);
        Assert.assertEquals(futureDate, actualFutureDate);
    }
}
