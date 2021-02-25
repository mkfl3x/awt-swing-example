import org.junit.jupiter.api.BeforeEach;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

abstract public class TestBase {

    protected Robot robot;

    protected Application application;

    @BeforeEach
    private void beforeEach() throws AWTException {
        application = new Application();
        robot = new Robot();
        robot.delay(2000);
    }

    public void click(Component component) {
        Point point = component.getLocationOnScreen();
        robot.mouseMove(point.x, point.y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000);
    }

    public void input(JTextField field, String value) {
        click(field);
        for (char c : value.toCharArray()) {
            robot.keyPress(c);
            robot.keyRelease(c);
        }
        robot.delay(1000);
    }

    public String read(JTextField field) {
        return field.getText();
    }
}