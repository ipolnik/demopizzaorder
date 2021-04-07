package com.sample.test.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageBase extends TestBase {
    WebDriver driver;
    RandomGenerator randomGenerator;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        randomGenerator = new RandomGenerator();
    }

    public void selectFromDropDown(By dropdownElement, String value) {
        Select dropdown = new Select(driver.findElement(dropdownElement));
        dropdown.selectByValue(value);
    }

    public void selectFromDropDown(WebElement dropdownElement, String value) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    protected void inputText(By element, String inputText) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(inputText);
    }

    protected void click(By element) {
        driver.findElement(element).click();
    }

    protected String getElementText(By element){
       return driver.findElement(element).getText();
    }

    protected String getElementTextByValue(By element){
        return driver.findElement(element).getAttribute("value");
    }

    protected String getElementTextByValue(WebElement element){
        return element.getAttribute("value");
    }

    protected List<WebElement> findElements(By by){
        return driver.findElements(by);
    }
}
