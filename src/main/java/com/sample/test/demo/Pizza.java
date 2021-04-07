package com.sample.test.demo;

import java.util.List;

public interface Pizza {
    void selectRandomPizzaSize(String pizzaType);
    void selectRandomPizzaTopping(List<String> topping);
    void selectRandomQuantity(int min, int max);
    void enterRandomPickupInformation();
    void selectRandomPayment();
}
