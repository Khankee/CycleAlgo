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

    private Integer wgNumber;
    private List<int[]> travels;
    private List<LoopData> miniData;

    @Override
    public String toString() {
        return "Wagon{" +
                "wgNumber=" + wgNumber +
                "lengths = " + travels.size() +
                ",travels=" + Arrays.toString(travels.toArray()) +
                '}';
    }
}
