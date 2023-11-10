import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
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
        Point location= webElement.getLocation();
        Dimension size= webElement.getSize();
        Point centerOfElement= getcenterOFElement(location, size);

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

    private Point getcenterOFElement(Point location, Dimension size){
        return new Point(location.getX() + size.getWidth()/2, location.getY() + size.getHeight()/2);
    }

}
