package com.sample.test.demo.constants;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum PizzaToppings {
    MANGOS("Diced Mango"),
    OLIVES("Olives"),
    MUSHROOMS("Mushrooms"),
    ONIONS("Caramelized onions"),
    ITALIANHAM("Italian Ham"),
    PEPPERONI("Classic Pepperoni"),
    SALAMI("Salami"),
    PROVOLNE("Provolone cheese"),
    EXTRACHEESE("Extra cheese"),
    MOZZARELLA("Mozzarella cheese"),
    PARMASAN("Parmesan cheese");

    private String displayName;

    private PizzaToppings(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static PizzaToppings generateRandomTopping() {
        PizzaToppings[] values = PizzaToppings.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }
    public static List<String> generateRandomToppings(int amount) {
        List<String> toppings = new ArrayList<>();
        for(int i = 0; i < amount; i++){
            toppings.add(PizzaToppings.generateRandomTopping().getDisplayName());
        }
        return toppings;
    }
}
