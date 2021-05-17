import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class WebDriverTest {
    private WebDriver driver;

    @BeforeEach
    public void initDriver() throws Exception {
        System.setProperty("webdriver.url", "http://localhost:4444/wd/hub");
        System.setProperty("webdriver.browser", "chrome");
        System.setProperty("webdriver.remote", "false");

        System.setProperty("webdriver.chrome.driver", "/Users/kitty/IdeaProjects/study/chromedriver");
        String webDriverRemote = System.getProperty("webdriver.remote");
        if (webDriverRemote.equals("true")) {
            String url = System.getProperty("webdriver.url");
            String browser = System.getProperty("webdriver.browser");
            if (browser.equals("chrome")) {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                driver = new RemoteWebDriver(new URL(url), capabilities);
            }
            if (browser.equals("firefox")) {
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                driver = new RemoteWebDriver(new URL(url), capabilities);
            }
            if (browser.equals("opera")) {
                DesiredCapabilities capabilities = DesiredCapabilities.opera();
                driver = new RemoteWebDriver(new URL(url), capabilities);
            }
        } else {
            driver = new ChromeDriver();
        }
    }

    @Test
    public void testWebDriver() {
        driver.get("https://github.com/");
        assertThat(driver.getTitle())
                .isEqualTo("GitHub: Where the world builds software · GitHub");
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }
}
