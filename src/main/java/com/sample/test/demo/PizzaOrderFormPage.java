package com.sample.test.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class PizzaOrderFormPage extends PageBase implements Pizza {
    public PizzaOrderFormPage(WebDriver driver) { super(driver); }

    public static By pizza1 = By.id("pizza1Pizza");
    public static By pizza1Toppings = By.xpath("//*[contains(@class,'toppings')]");
    public static By pizza1Quantity = By.id("pizza1Qty");
    public static By pizza1Cost = By.id("pizza1Cost");
    public static By radioCreditCard  = By.id("ccpayment");
    public static By radioCash = By.id("cashpayment");
    public static By email = By.id("email");
    public static By name = By.id("name");
    public static By phone = By.id("phone");
    public static By placeOrderButton = By.id("placeOrder");
    public static By resetButton = By.id("reset");
    public static By dialog = By.id("dialog");
    public static By dialogText = By.xpath("//div[@id='dialog']/p");

    public void selectRandomPizzaSize(String pizzaType){
        selectFromDropDown(pizza1, pizzaType);
    }
    public void selectRandomPizzaTopping(List<String> topping){
        List<WebElement> toppings = findElements(pizza1Toppings);
        for(int i = 0; i < toppings.size(); i++)
        selectFromDropDown(toppings.get(i), topping.get(i));
    }

    public void selectRandomQuantity(int min, int max){
         int random = (int)(Math.random() * max + min);
         inputText(pizza1Quantity, String.valueOf(random));
    }

    public void enterRandomPickupInformation(){
    inputText(name, randomGenerator.randomStringFromGiven("AbCdEfgHI#$%" + " " + "AbCdEfgHI#$%", 3, 10));
        inputText(email, randomGenerator.randomStringFromGiven("QfRfgfgfER@", 3, 10)+ ".com");
        inputText(phone, "+1" + randomGenerator.randomStringFromGiven("0123456789", 10, 10));
    }

    public void selectRandomPayment(){
        Random rnd = new Random();
        List<WebElement> radios = driver.findElements(By.xpath("//*[contains(@id,'payment')]"));
        radios.get(rnd.nextInt(radios.size())).click();
    }

    public void clickPlaceOrderButton(){
        click(placeOrderButton);
    }

    public String getDialogBoxText(){
        return getElementText(dialogText);
    }

    public String getPizzaCost(){
        return getElementTextByValue(pizza1Cost);
    }

    public void clickResetButton(){
        click(resetButton);
    }

    public String getDropDownValueSize(){
          String value = getElementTextByValue(pizza1);
          return value;
    }

    public String getDropDownValueTopping1(){
        String value = getElementTextByValue(findElements(pizza1Toppings).get(0));
        return value;
    }
}
