package com.sample.test.demo.tests;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PizzaOrderHappyPathTests extends TestBase {

    @Test
    public void pizzaOrderHappyPath() {
        /**
         * Select random pizza and place an order
         * 1. Navigate to Pizza Order Form page.
         * 2. Select random size of pizza.
         * 3. Select random topping 1.
         * 4. Select random topping 2.
         * 5. Enter random Quantity
         * 6. Enter random pick up information
         * 7. Choose random payment method
         * 8. Click place an order
         * 9. Verify that order successfully placed
         */
        String randomPizzaType = PizzaTypes.generateRandomType().getDisplayName();

        driver.get(url);

        pizzaOrderFormPage.selectRandomPizzaSize(randomPizzaType);

        pizzaOrderFormPage.selectRandomPizzaTopping1(PizzaToppings.generateRandomTopping().getDisplayName());

        pizzaOrderFormPage.selectRandomPizzaTopping2(PizzaToppings.generateRandomTopping().getDisplayName());

        pizzaOrderFormPage.selectRandomQuantity(1, 10);

        pizzaOrderFormPage.enterRandomPickupInformation();

        pizzaOrderFormPage.selectRandomPayment();

        String cost = pizzaOrderFormPage.getPizzaCost();

        pizzaOrderFormPage.clickPlaceOrderButton();

        // Assert that dialog box message is correct and contains pizza cost and selected type
        Assert.assertTrue(pizzaOrderFormPage.getDialogBoxText().equals("Thank you for your order! TOTAL: " + cost + " " + randomPizzaType));
    }
        @Test
        public void pizzaOrderReset(){

            /**
             *
             * Reset pizza size and toppings
             * 1. Navigate to Pizza Order Form page.
             * 2. Select random type of pizza.
             * 3. Select random topping 1.
             * 4. Select random topping 2.
             * 7. Click Reset button
             * 8. Verify that pizza type and toppings dropdown is reset to default
             */

            driver.get(url);

            pizzaOrderFormPage.selectRandomPizzaSize(PizzaTypes.generateRandomType().getDisplayName());

            pizzaOrderFormPage.selectRandomPizzaTopping1(PizzaToppings.generateRandomTopping().getDisplayName());

            pizzaOrderFormPage.selectRandomPizzaTopping2(PizzaToppings.generateRandomTopping().getDisplayName());

            pizzaOrderFormPage.clickResetButton();

            // Assert that user is able to reset pizza size and toppings
            // Second soft assert is expected to fail, because Reset button doesn't reset toppings
            SoftAssert softAssert = new SoftAssert();
            Assert.assertTrue(pizzaOrderFormPage.getDropDownValueSize().equals("- $00.00"));
            Assert.assertTrue(pizzaOrderFormPage.getDropDownValueTopping1().equals("Choose a Toppings 1"), "This soft assert is expected to fail");
        }
}
