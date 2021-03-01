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
        robot.delay(1000);
    }

    public void click(Component component) {
        int width = component.getWidth();
        int height = component.getHeight();
        Point point = component.getLocationOnScreen();
        robot.mouseMove(point.x + width / 2, point.y + height / 2);
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