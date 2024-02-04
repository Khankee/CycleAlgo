package org.network.functions;

import org.network.entities.Result;
import org.network.entities.Wagon;

import java.util.*;

public class CycleFinderAlgorithm {

    private final List<Integer> cycles = new ArrayList<>();
    private final List<Integer> weights = new ArrayList<>();
    private final StringBuilder visualisation = new StringBuilder();
    private final HashSet<Integer> visited = new HashSet<>();
    private final List<Result> results = new ArrayList<>();

    private void reset(){
        cycles.clear();
        weights.clear();
        visited.clear();
        visualisation.setLength(0);
    }

    public List<Result> findCycles(Map<Integer, Wagon> wagons, Map<Integer, String> namingStations){
        for (Wagon wagon : wagons.values()){
            int wgNumber = wagon.getWgNumber();
            List<int[]> travels = wagon.getTravels();
            List<Integer> gu12s = wagon.getGu12();
            reset();
            cycles.add(travels.get(0)[0]);
            weights.add(gu12s.get(0));
            visualisation
                    .append(namingStations.get(travels.get(0)[0]))
                    .append(" ГУ12: ")
                    .append(gu12s.get(0))
                    .append(" ");

            visited.add(travels.get(0)[0]);

            for (int i = 1; i < travels.size(); i++){
                int[] pair = travels.get(i);
                if(pair[0] == pair[1]) continue;
                int[] prev = travels.get(i - 1);

                topUp(namingStations, gu12s, i, pair);

                if(pair[0] != prev[1]) {
                    reset();
                    continue;
                }
                if(visited.contains(pair[1])){
                    cycles.add(pair[1]);
                    weights.add(gu12s.get(i));
                    visualisation
                            .append(namingStations.get(pair[1])).append(" ");

                    if(cycles.get(0) != pair[1]){
                        cleanCycle();
                    }

                    Result result = new Result(
                            wgNumber,
                            new ArrayList<>(cycles),
                            new ArrayList<>(weights),
                            visualisation.toString()
                    );

                    results.add(result);
                    reset();
                }

            }
        }
        return results;
    }

    private void cleanCycle() {
        while (!Objects.equals(cycles.get(0), cycles.get(cycles.size() - 1))) {
            cycles.remove(0);
        }
    }

    private void topUp(Map<Integer, String> namingStations, List<Integer> info, int i, int[] pair) {
        cycles.add(pair[0]);
        weights.add(info.get(i));
        visualisation
                .append(namingStations.get(pair[0]))
                .append(" ГУ12: ")
                .append(info.get(i))
                .append(" ");

        visited.add(pair[0]);
    }
}
