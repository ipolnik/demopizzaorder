package com.sample.test.demo.tests;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PizzaOrderNegativeTests extends TestBase {
    @Test
    public void pizzaOrderNegativePath() throws Exception{
        String randomPizzaType = PizzaTypes.generateRandomType().getDisplayName();
        String randomPizzaTopping1 = PizzaToppings.generateRandomTopping().getDisplayName();
        String randomPizzaTopping2 = PizzaToppings.generateRandomTopping().getDisplayName();

        /**
         * User not able to place an order if pickup information is missing
         * 1. Navigate to Pizza Order Form page.
         * 2. Select random type of pizza.
         * 3. Select random topping 1.
         * 4. Select random topping 2.
         * 5. Enter random Quantity
         * 6. Choose random payment method
         * 7. Click place an order
         * 8. Verify that order successfully placed
         */

        driver.get(url);
        Thread.sleep(4000);
        pizzaOrderFormPage.selectRandomPizzaSize(randomPizzaType);

        pizzaOrderFormPage.selectRandomPizzaTopping1(randomPizzaTopping1);

        pizzaOrderFormPage.selectRandomPizzaTopping2(randomPizzaTopping2);

        pizzaOrderFormPage.selectRandomQuantity(1, 10);

        pizzaOrderFormPage.selectRandomPayment();

        pizzaOrderFormPage.clickPlaceOrderButton();

        // Assert that dialog box message is showing that pickup information is missing
        Assert.assertTrue(pizzaOrderFormPage.getDialogBoxText().equals( "Missing name\nMissing phone number" ));
        Thread.sleep(4000);
    }
}