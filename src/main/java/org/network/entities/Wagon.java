package org.network.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Wagon {

    private int wgNumber;
    private List<int[]> travels;
    private List<Integer> gu12;

    @Override
    public String toString() {
        return "Wagon{" +
                "wgNumber=" + wgNumber +
                "lengths = " + travels.size() + ":" + gu12 +
                ", travels=" + Arrays.toString(travels.toArray()) +
                ", info=" + gu12 +
                '}';
    }
}
