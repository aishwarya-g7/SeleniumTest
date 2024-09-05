package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonFlows {
    public static WebElement findWebElement(WebDriver driver, By by){
        return driver.findElement(by);
    }
}
