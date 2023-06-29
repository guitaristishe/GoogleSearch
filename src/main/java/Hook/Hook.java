package Hook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Hook {
    public WebDriver driver;
    public Properties properties;
    private final String path = "src/main/java/Config/config.properties";

    public Hook() throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(path));
        properties.load(reader);
    }

    public String getDriver() {
        String browser = properties.getProperty("browser");
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("No such browser");
        }
        driver.manage().window().fullscreen();
        String url = properties.getProperty("url");
        driver.get(url);
        return browser;
    }

}
