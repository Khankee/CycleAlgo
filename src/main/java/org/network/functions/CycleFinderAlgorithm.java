package org.network.functions;

import org.network.entities.Result;
import org.network.entities.Wagon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class CycleFinderAlgorithm {

    List<Integer> cycles = new ArrayList<>();
    List<Integer> weights = new ArrayList<>();
    int totalDistance = 0;
    StringBuilder visualisation = new StringBuilder();
    HashSet<Integer> visited = new HashSet<>();


    public List<Result> findCycles(Map<Integer, Wagon> wagons, Map<Integer, String> namingStations){
        List<Result> results = new ArrayList<>();

        int counter = 0;
        for (Wagon wagon : wagons.values()){
            int wgNumber = wagon.getWgNumber();
            System.out.println(counter += 1);
            List<int[]> travels = wagon.getTravels();
            List<int[]> info = wagon.getInfo();
            reset();
            cycles.add(travels.get(0)[0]);
            weights.add(info.get(0)[0]);
            visualisation
                    .append(namingStations.get(travels.get(0)[0]))
                    .append(" ГУ12: ")
                    .append(info.get(0)[0])
                    .append(" ");

            visited.add(travels.get(0)[0]);


            for (int i = 1; i < travels.size(); i++){
                int[] pair = travels.get(i);
                if(pair[0] == pair[1]) continue;
                int[] prev = travels.get(i - 1);
                if(pair[0] != prev[1]) {
                    reset();
                    cycles.add(pair[0]);
                    weights.add(info.get(i)[0]);
                    totalDistance += info.get(i)[1];
                    visualisation
                            .append(namingStations.get(pair[0]))
                            .append(" ГУ12: ")
                            .append(info.get(i)[0])
                            .append(" ");

                    visited.add(pair[0]);
                    continue;
                }
                cycles.add(pair[0]);
                weights.add(info.get(i)[0]);
                totalDistance += info.get(i)[1];
                visualisation
                        .append(namingStations.get(pair[0]))
                        .append(" ГУ12: ")
                        .append(info.get(i)[0])
                        .append(" ");

                visited.add(pair[0]);

                if(visited.contains(pair[1])){
                    cycles.add(pair[1]);
                    weights.add(info.get(i)[0]);
                    totalDistance += info.get(i)[1];
                    visualisation
                            .append(namingStations.get(pair[1])).append(" ");

                    Result result = new Result(
                            wgNumber,
                            cycles,
                            weights,
                            totalDistance,
                            visualisation.toString()
                    );
                    results.add(result);
                    reset();
                }

            }
        }

        return results;
    }

    void reset(){
        cycles.clear();
        weights.clear();
        visited.clear();
        totalDistance = 0;
        visualisation.setLength(0);
    }

    public void print() {
        System.out.println(
                "cycles=" + cycles +
                ", weights=" + weights +
                ", totalDistance=" + totalDistance +
                ", visualisation=" + visualisation +
                ", visited=" + visited +
                '}');
    }
}
