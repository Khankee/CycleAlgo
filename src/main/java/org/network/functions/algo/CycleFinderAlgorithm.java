package org.network.functions.algo;

import org.network.entities.LoopData;
import org.network.entities.Result;
import org.network.entities.Wagon;

import java.util.*;

public class CycleFinderAlgorithm {

    private final List<Integer> cycles = new ArrayList<>();
    private final List<LoopData> loopData = new ArrayList<>();
    private final HashSet<Integer> visited = new HashSet<>();
    private final List<Result> results = new ArrayList<>();

    private void reset() {
        cycles.clear();
        visited.clear();
        loopData.clear();
    }

    public List<Result> findCycles(Map<Integer, Wagon> wagons) {
        for (Wagon wagon : wagons.values()) {
            int wgNumber = wagon.getWgNumber();
            List<int[]> travels = wagon.getTravels();
            List<LoopData> lps = wagon.getMiniData();

            reset();

            loopData.add(lps.get(0));
            cycles.add(travels.get(0)[0]);
            visited.add(travels.get(0)[0]);

            for (int i = 1; i < travels.size(); i++) {

                int[] pair = travels.get(i);
                LoopData lp = lps.get(i);
                if (pair[0] == pair[1]) continue;

                int[] prev = travels.get(i - 1);

                topUp(pair, lp);

                if (pair[0] != prev[1]) {
                    reset();
                    continue;
                }

                if (visited.contains(pair[1])) {
                    cycles.add(pair[1]);

                    if (cycles.get(0) != pair[1]) {
                        cleanCycle();
                    }

                    Result result = new Result(
                            wgNumber,
                            new ArrayList<>(cycles),
                            new ArrayList<>(loopData)
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
            loopData.remove(0);
        }
    }

    private void topUp(int[] pair, LoopData lp) {
        cycles.add(pair[0]);
        loopData.add(lp);
        visited.add(pair[0]);
    }
}
