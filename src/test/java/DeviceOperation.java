import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class DeviceOperation {

    AndroidDriver deviceAndroidDriver;

    public DeviceOperation(AndroidDriver androidDriver){
        deviceAndroidDriver= androidDriver;
    }

    public void tap(WebElement webElement){
        // step 1
        Point centerOfElement= new Point(webElement.getLocation().getX() + webElement.getSize().getWidth(),
                webElement.getLocation().getY() + webElement.getSize().getHeight());

        // step 2
        PointerInput finger= new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence steps= new Sequence(finger,1);
        steps.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerOfElement));
        steps.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        steps.addAction(new Pause(finger,Duration.ofMillis(200)));
        steps.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // step 3
        deviceAndroidDriver.perform(Collections.singleton(steps));
    }

    public void doubleTap(WebElement webElement){
        // step 1
        Point centerOfElement= new Point(webElement.getLocation().getX() + webElement.getSize().getWidth(),
                webElement.getLocation().getY() + webElement.getSize().getHeight());

        // step 2
        PointerInput finger= new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence steps= new Sequence(finger,1);
        steps.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerOfElement));
        steps.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        steps.addAction(new Pause(finger,Duration.ofMillis(50)));
        steps.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        steps.addAction(new Pause(finger,Duration.ofMillis(50)));
        steps.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        steps.addAction(new Pause(finger,Duration.ofMillis(50)));
        steps.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // step 3
        deviceAndroidDriver.perform(Collections.singleton(steps));
    }

    public void longPress(WebElement webElement){
        // step 1
        Point centerOfElement= new Point(webElement.getLocation().getX() + webElement.getSize().getWidth(),
                webElement.getLocation().getY() + webElement.getSize().getHeight());

        // step 2
        PointerInput finger= new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence steps= new Sequence(finger,1);
        steps.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerOfElement));
        steps.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        steps.addAction(new Pause(finger,Duration.ofSeconds(2)));
        steps.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // step 3
        deviceAndroidDriver.perform(Collections.singleton(steps));
    }

}
