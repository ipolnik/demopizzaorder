**Note!**

1. Chrome driver was updated from v74 to 89
2. URL and platform values was changed in properties file(please update it before run localy)
3. "Reset pizza type and toppings" test case is expected to fail on second soft assert.(Reset button doesn't reset toppings)

**Test cases**
**Select random pizza and place an order**
 1. Navigate to Pizza Order Form page.
 2. Select random size of pizza.
 3. Select random topping 1.
 4. Select random topping 2.
 5. Enter random Quantity
 6. Enter random pick up information
 7. Choose random payment method
 8. Click place an order
 9. Verify that order successfully placed
          
 **Reset pizza size and toppings**
  1. Navigate to Pizza Order Form page.
  2. Select random type of pizza.
  3. Select random topping 1.
  4. Select random topping 2.
  7. Click Reset button
  8. Verify that pizza type and toppings dropdown is reset to default
             
 **User not able to place an order if pickup information is missing**
  1. Navigate to Pizza Order Form page.
  2. Select random type of pizza.
  3. Select random topping 1.
  4. Select random topping 2.
  5. Enter random Quantity
  6. Choose random payment method
  7. Click place an order
  8. Verify missing name and phone number message is shown


