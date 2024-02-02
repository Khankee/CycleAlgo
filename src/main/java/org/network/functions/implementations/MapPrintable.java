package org.network.functions.implementations;

import org.network.functions.Printable;

import java.util.List;
import java.util.Map;

public class MapPrintable implements Printable {

    @Override
    public void printMap(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    @Override
    public void printTest(List<int[]> test) {
        for (int[] array : test) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println(); // Move to the next line after printing all elements of an array
        }
    }
}
