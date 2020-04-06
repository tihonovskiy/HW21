import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.AssertJUnit.assertTrue;

public class FindStylusUAinGoogle {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void driverSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get("https://www.google.com/webhp");
    }

    /*@AfterSuite
    public void quiteBrowser() {
        driver.quit();
    }*/

    @Test
    public void iphoneKyivBuyFind() {
        driver.findElement(By.name("q")).sendKeys("iphone kyiv buy");
        driver.findElement(By.name("q")).submit();
        try {
            assertTrue(driver.findElement(By.partialLinkText("stylus.ua")).isDisplayed());
        } catch (NoSuchElementException e1) {
            driver.findElement(By.xpath("//a[@aria-label='Page 2']")).click();
            try {
                assertTrue(driver.findElement(By.partialLinkText("stylus.ua")).isDisplayed());
            } catch (NoSuchElementException e2) {
                driver.findElement(By.xpath("//a[@aria-label='Page 3']")).click();
                try{
                    assertTrue(driver.findElement(By.partialLinkText("stylus.ua")).isDisplayed());
                } catch (NoSuchElementException e3) {
                    driver.findElement(By.xpath("//a[@aria-label='Page 4']")).click();
                    try {
                        assertTrue(driver.findElement(By.partialLinkText("stylus.ua")).isDisplayed());
                    } catch (NoSuchElementException e4) {
                        driver.findElement(By.xpath("//a[@aria-label='Page 5']")).click();
                        assertTrue(driver.findElement(By.partialLinkText("stylus.ua")).isDisplayed());
                    }
                }
            }

        }
    }
}
