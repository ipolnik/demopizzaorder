package com.sample.test.demo.tests;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PizzaOrderHappyPathTests extends TestBase {
    @Test
    public void pizzaOrderHappyPath(){
        String randomPizzaType = PizzaTypes.generateRandomType().getDisplayName();
        String randomPizzaTopping1 = PizzaToppings.generateRandomTopping().getDisplayName();
        String randomPizzaTopping2 = PizzaToppings.generateRandomTopping().getDisplayName();
        String cost;

        /**
         * Select random pizza and place an order
         * 1. Navigate to Pizza Order Form page.
         * 2. Select random type of pizza.
         * 3. Select random topping 1.
         * 4. Select random topping 2.
         * 5. Enter random Quantity
         * 6. Enter random pick up information
         * 7. Choose random payment method
         * 8. Click place an order
         * 9. Verify that order successfully placed
         */
        driver.get(url);

        pizzaOrderFormPage.selectRandomPizzaSize(randomPizzaType);

        pizzaOrderFormPage.selectRandomPizzaTopping1(randomPizzaTopping1);

        pizzaOrderFormPage.selectRandomPizzaTopping2(randomPizzaTopping2);

        pizzaOrderFormPage.selectRandomQuantity(1, 10);

        pizzaOrderFormPage.enterRandomPickupInformation();

        pizzaOrderFormPage.selectRandomPayment();

        cost = pizzaOrderFormPage.getPizzaCost();

        pizzaOrderFormPage.clickPlaceOrderButton();

        // Assert that dialog box message is correct and contains pizza cost and selected type
        Assert.assertTrue(pizzaOrderFormPage.getDialogBoxText().equals("Thank you for your order! TOTAL: "+ cost +" " + randomPizzaType));
    }
}
