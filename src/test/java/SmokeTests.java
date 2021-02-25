import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmokeTests extends TestBase {

    @ParameterizedTest
    @CsvSource(value = {"2:2:4", "2:3:5", "0:7:7", "7:0:7", "-2:-2:-4", "-5:2:-3", "-2:4:2"}, delimiter = ':')
    void positiveCases(String first, String second, String result) {
        input(application.getFirstOperand(), first);
        input(application.getSecondOperand(), second);
        click(application.getSumButton());
        assertEquals(result, read(application.getResultField()));
    }
}