package org.network.functions.implementations;

import org.network.entities.Wagon;

import java.util.List;
import java.util.Map;

/**
 * @author: Kenes Arukhan
 * @date: 02.02.2024
 * @email: Arukhan.kenes@gmail.com
 *
 * @explanation: Class Printable holds all void print methods for future usage of debugging.
 * Add own methods here.
 */

public class Printable {

    public void printMap(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
    public void printWagonMap(Map<Integer, Wagon> map) {
        for (Map.Entry<Integer, Wagon> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
    public void printTest(List<int[]> test) {
        for (int[] array : test) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
