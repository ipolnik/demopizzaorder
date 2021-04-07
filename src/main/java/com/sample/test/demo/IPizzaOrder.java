package com.sample.test.demo;

public interface IPizzaOrder {
    void selectRandomPizzaSize(String pizzaType);
    void selectRandomPizzaTopping1(String topping);
    void selectRandomPizzaTopping2(String topping);
    void selectRandomQuantity(int min, int max);
    void enterRandomPickupInformation();
    void selectRandomPayment();
}
