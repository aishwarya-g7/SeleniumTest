package assignementTests;
import assignment.pageObjectFile.LoginPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class BasicSetup {

    public static WebDriver driver;
    public LoginPageObjects loginPageObjects;


    public void launchBrowser(){
        initializeDriver("Chrome");
        loginPageObjects = new LoginPageObjects(driver);
        loginPageObjects.navigateToApplication();
    }

    public WebDriver getDriver(){
        if(driver==null) {
            initializeDriver("Chrome");
        }
        return driver;
    }
    public void initializeDriver(String driverName) {
        try {
            if (driver == null) {
            switch (driverName) {
                case "Chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                    driver.manage().window().maximize();
                    break;
                case "Edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                    driver.manage().window().maximize();
                    break;
                case "Internet Explorer":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                    driver.manage().window().maximize();
                    break;
                default:
                    System.out.println("Invalid driver option");
            }
        }
        }
        catch (Exception e) {
           e.printStackTrace();
        }
    }

}
