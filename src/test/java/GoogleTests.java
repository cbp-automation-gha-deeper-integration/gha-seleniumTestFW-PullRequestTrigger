import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GoogleTests {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testSearchFieldPresence() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        assertNotNull("Search box should be present on webpage", searchBox);
    }

    @Test
    public void testClickGmailLink() {
        driver.get("https://www.google.com");
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        assertTrue("Gmail link should be visible", gmailLink.isDisplayed());
        gmailLink.click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
