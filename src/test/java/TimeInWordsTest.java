import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

public class TimeInWordsTest {
    @Autowired
    TimeInWordService timeInWordService;
    @Before
    public void setup() {
        this.timeInWordService = new TimeInWordService();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void convertReturnsAmTime() {
        Object convert = this.timeInWordService.convert("08:34");

        assertThat(convert, is(
                allOf(notNullValue(), instanceOf(String.class), equalTo("It's eight thirty four"))));
    }


        @SuppressWarnings("unchecked")
        @Test
        public void convertReturnsMidnight() {
            Object convert = this.timeInWordService.convert("00:00");

            assertThat(convert, is(
                    allOf(notNullValue(), instanceOf(String.class), equalTo("It's Midnight"))));
        }

        @SuppressWarnings("unchecked")
        @Test
        public void convertReturnsMidday() {
            Object convert = this.timeInWordService.convert("12:00");

            assertThat(convert, is(
                    allOf(notNullValue(), instanceOf(String.class), equalTo("It's Midday"))));
        }


}
