package org.network.functions.implementations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.network.entities.Data;
import org.network.entities.Wagon;
import org.network.functions.ExtractDataFunctions;
import org.network.functions.Printable;

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

            int distance = data.getDistance();
            int gu12 = data.getGu12Number();

            String nameFrom = data.getNameFrom();
            String nameTo = data.getNameTo();

            namingStations.putIfAbsent(from, nameFrom);
            namingStations.putIfAbsent(to, nameTo);

            int[] travel = {from, to};
            int[] info = {gu12, distance};

            if(wagons.get(id) == null){
                ArrayList<int[]> travels = new ArrayList<>();
                ArrayList<int[]> infos = new ArrayList<>();

                travels.add(travel);
                infos.add(info);

                Wagon wagon = new Wagon(id, travels, infos);

                wagons.put(id,wagon);
                continue;
            }
            Wagon wagon = wagons.get(id);
            wagon.getTravels().add(travel);
            wagon.getInfo().add(info);
            wagons.put(id, wagon);
        }
        return wagons;
    }
}
