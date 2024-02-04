package org.network.functions.implementations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.network.entities.Data;
import org.network.entities.Wagon;
import org.network.functions.ExtractDataFunctions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ExtractDataFunctionImplementation implements ExtractDataFunctions {

    private Map<Integer, String> namingStations;

    @Override
    public Map<Integer, Wagon> extractWagonTravels(List<Data> dataList) {
        Map<Integer, Wagon> wagons = new HashMap<>();
        namingStations = new HashMap<>();

        for (Data data : dataList){
            int id = data.getWgNumber();

            int from = data.getDeparture();
            int to = data.getArrival();

            int gu12 = data.getGu12Number();

            String nameFrom = data.getNameFrom();
            String nameTo = data.getNameTo();

            namingStations.putIfAbsent(from, nameFrom);
            namingStations.putIfAbsent(to, nameTo);

            int[] travel = {from, to};

            if(wagons.get(id) == null){
                ArrayList<int[]> travels = new ArrayList<>();
                ArrayList<Integer> gu12s = new ArrayList<>();

                travels.add(travel);
                gu12s.add(gu12);

                Wagon wagon = new Wagon(id, travels, gu12s);

                wagons.put(id,wagon);
                continue;
            }
            Wagon wagon = wagons.get(id);
            wagon.getTravels().add(travel);
            wagon.getGu12().add(gu12);
            wagons.put(id, wagon);
        }
        return wagons;
    }
}
