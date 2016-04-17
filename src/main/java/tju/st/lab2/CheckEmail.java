package tju.st.lab2;

/**
 * Created by gmy on 16/4/13.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CheckEmail {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private List<String[]> dataList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.ncfxy.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        dataList = CSVUtil.readCSV(CSVUtil.class.getClassLoader().getResource("info.csv").getPath());
    }

    @Test
    public void test() throws Exception {
        for (String[] data : dataList) {
            driver.get(baseUrl + "/");
            driver.findElement(By.id("name")).clear();
            driver.findElement(By.id("name")).sendKeys(data[0]);
            driver.findElement(By.id("pwd")).clear();
            driver.findElement(By.id("pwd")).sendKeys(data[0].substring(4));
            new Select(driver.findElement(By.id("gender"))).selectByVisibleText("女");
            driver.findElement(By.id("submit")).click();
            WebElement tbody = driver.findElement(By.id("table-main"));
            List<WebElement> tds = tbody.findElements(By.tagName("td"));
            assertEquals(tds.get(1).getText(),data[1]);
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
