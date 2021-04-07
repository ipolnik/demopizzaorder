package com.sample.test.demo;

import static org.testng.Assert.fail;

import com.sample.test.demo.configuration.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestBase {

    private Configuration config;
    protected WebDriver driver;
    protected String url;
    public PizzaOrderFormPage pizzaOrderFormPage;

    @BeforeMethod
    public void initDriver(){
        pizzaOrderFormPage = new PizzaOrderFormPage(driver);
    }

    @BeforeClass(alwaysRun = true)
    public void init() throws Throwable {
        config = new Configuration();
        url = config.getUrl();
        initializeDriver();
        navigateToSite();

    }

    private void navigateToSite() {
        driver.get(url);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        try {
            driver.quit();

        } catch (Exception e) {
        }
    }

    private void initializeDriver() {
        if (config.getBrowser().equalsIgnoreCase("chrome")) {
            if (config.getPlatform().equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/mac/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver",
                        "src/test/resources/chromedriver/windows/chromedriver.exe");
            }
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else {
            fail("Unsupported bfrowser " + config.getBrowser());
        }
    }
}
