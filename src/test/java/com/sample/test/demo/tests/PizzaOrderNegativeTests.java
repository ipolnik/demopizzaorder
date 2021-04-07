package com.sample.test.demo.tests;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PizzaOrderNegativeTests extends TestBase {
    @Test
    public void pizzaOrderNegativePath(){
        String randomPizzaType = PizzaTypes.generateRandomType().getDisplayName();

        /**
         * User not able to place an order if pickup information is missing
         * 1. Navigate to Pizza Order Form page.
         * 2. Select random type of pizza.
         * 3. Select random topping 1.
         * 4. Select random topping 2.
         * 5. Enter random Quantity
         * 6. Choose random payment method
         * 7. Click place an order
         * 8. Verify missing name and phone number message is shown
         */

        driver.get(url);

        pizzaOrderFormPage.selectRandomPizzaSize(randomPizzaType);

        pizzaOrderFormPage.selectRandomPizzaTopping(PizzaToppings.generateRandomToppings(2));

        pizzaOrderFormPage.selectRandomQuantity(1, 10);

        pizzaOrderFormPage.selectRandomPayment();

        pizzaOrderFormPage.clickPlaceOrderButton();

        // Assert that dialog box message is showing that pickup information is missing
        Assert.assertTrue(pizzaOrderFormPage.getDialogBoxText().equals( "Missing name\nMissing phone number" ));
    }
}
