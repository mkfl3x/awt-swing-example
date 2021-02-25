import org.junit.jupiter.api.BeforeEach;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

abstract public class TestBase {

    protected MainFrame frame;

    private Robot robot;

    private void wait(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void click(Component component) {
        Point point = component.getLocationOnScreen();
        robot.mouseMove(point.x, point.y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        wait(1);
    }

    protected void input(JTextField field, String value) {
        click(field);
        for (char c : value.toCharArray()) {
            robot.keyPress(c);
            robot.keyRelease(c);
        }
        wait(1);
    }

    protected String read(JTextField field) {
        return field.getText();
    }

    @BeforeEach
    private void beforeEach() throws AWTException {
        this.frame = new MainFrame();
        this.robot = new Robot();
    }
}
