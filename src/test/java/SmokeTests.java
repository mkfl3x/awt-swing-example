import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmokeTests extends TestBase {

    @Test
    public void first() {
        input(frame.getFirstOperand(), "2");
        input(frame.getSecondOperand(), "3");
        click(frame.getSumButton());
        assertEquals("5", read(frame.getResultField()));
    }
}