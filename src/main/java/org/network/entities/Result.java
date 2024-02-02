package org.network.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Result {
    private int wgNumber;
    private List<Integer> cycles;
    private List<Integer> weights;
    private int totalDistance;
    private String visualisation;

    @Override
    public String toString() {
        return "\n Result{" +
                "wgNumber=" + wgNumber +
                ", cycles=" + cycles +
                ", weights=" + weights +
                ", totalDistance=" + totalDistance +
                ", visualisation='" + visualisation + '\'' +
                '}';
    }
}
