package com.sample.test.demo;

import java.util.Random;

public class RandomGenerator {
    public String randomStringFromGiven(String givenString, int stringRangeMin, int stringRangeMax) {

        Random random = new Random();
        char[] chars = givenString.toCharArray();

        StringBuilder sb = new StringBuilder(random.nextInt(stringRangeMax + 1 - stringRangeMin) + stringRangeMin);

        int numberOfChar = random.nextInt(stringRangeMax + 1 - stringRangeMin) + stringRangeMin;
        for (int i = 0; i < numberOfChar; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();

        return output;
    }
}
