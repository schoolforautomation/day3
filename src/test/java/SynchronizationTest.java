import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SynchronizationTest {

    @Test
    public void synchronizationTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://school-for-automation.tech/home.html");
        driver.manage().window().maximize();

        /* Thread.sleep() */
        Thread.sleep(3000);
        WebElement getStartedButton = driver.findElement(By.id("get-started"));
        Assert.assertTrue(getStartedButton.isDisplayed());

        /* Implicit wait */
        // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // WebElement getStartedButton = driver.findElement(By.id("get-started"));
        // Assert.assertTrue(getStartedButton.isDisplayed());

        /* Explicit waits */
        // WebElement getStartedButton = new WebDriverWait(driver, 2)
        //         .until(ExpectedConditions.elementToBeClickable(By.id("get-started")));
        // WebElement getStartedButton = new WebDriverWait(driver, 2)
        //         .until(webDriver -> webDriver.findElement(By.id("get-started")));
        // Assert.assertTrue(getStartedButton.isDisplayed());

        /* Fluent wait */
        // Wait<WebDriver> wait = new FluentWait<>(driver)
        //         .withTimeout(Duration.ofSeconds(10))
        //         .pollingEvery(Duration.ofSeconds(2))
        //         .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        //
        // WebElement getStartedButton = wait.until(webDriver -> webDriver.findElement(By.id("get-started")));
        // Assert.assertTrue(getStartedButton.isDisplayed());

        driver.close();
    }
}
