package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

public class Task4 {

    public <T> T[] filter(T[] input, Predicate<T> p) {


        T[] result = (T[]) new Object[input.length];

        int counter = 0;
        for (T item : input) {
            if (p.test(item)) {
                result[counter] = item;
                counter++;
            }
        }

        return Arrays.copyOfRange(result, 0, counter);
    }
}