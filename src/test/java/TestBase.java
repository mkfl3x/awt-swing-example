import org.junit.jupiter.api.BeforeEach;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

abstract public class TestBase {

    protected Robot robot;

    protected Application application;

    @BeforeEach
    private void beforeEach() throws AWTException {
        application = new Application();
        robot = new Robot();
        robot.delay(1000);
    }

    protected void click(Component component) {
        int width = component.getWidth();
        int height = component.getHeight();
        Point point = component.getLocationOnScreen();
        robot.mouseMove(point.x + width / 2, point.y + height / 2);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000);
    }

    protected void input(JTextField field, String value) {
        click(field);
        for (char c : value.toCharArray()) {
            robot.keyPress(c);
            robot.keyRelease(c);
        }
        robot.delay(1000);
    }

    protected String read(JTextField field) {
        return field.getText();
    }

    protected void makeScreenshot(JComponent component) {
        try {
            Point location = component.getLocationOnScreen();
            Rectangle screenshotArea = new Rectangle(
                    location.x,
                    location.y,
                    component.getWidth(),
                    component.getHeight()
            );
            BufferedImage screenshot = robot.createScreenCapture(screenshotArea);
            ImageIO.write(screenshot, "png", new File("screenshot_" + LocalDateTime.now()));
        } catch (IOException e) {
            throw new RuntimeException("Screenshot preparation was failed");
        }
    }
}