package org.network.functions.implementations;

import org.network.entities.Data;
import org.network.entities.LoopData;
import org.network.entities.Wagon;
import org.network.functions.ExtractData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public record ExtractDataImplementation() implements ExtractData {

    @Override
    public Map<Integer, Wagon> extractWagonTravels(List<Data> dataList) {
        Map<Integer, Wagon> wagons = new HashMap<>();

        for (Data data : dataList) {
            LoopData miniData = new LoopData();

            int id = data.getWgNumber();

            String nameFrom = data.getNameFrom();
            String nameTo = data.getNameTo();

            int from = data.getDeparture();
            int to = data.getArrival();


            String dispatchNumber = data.getDispatchNumber();

            String dateOfDispatch = data.getDateOfDispatch();
            String dateOfDelivery = data.getDateOfDelivery();

            Double distance = data.getDistance();
            String routeType = data.getRouteType();

            miniData.setNameFrom(nameFrom);
            miniData.setNameTo(nameTo);
            miniData.setDeparture(from);
            miniData.setArrival(to);
            miniData.setDispatchNumber(dispatchNumber);
            miniData.setDateOfDispatch(dateOfDispatch);
            miniData.setDateOfDelivery(dateOfDelivery);
            miniData.setDistance(distance);
            miniData.setRouteType(routeType);

            int[] travel = {from, to};

            if (wagons.get(id) == null) {
                ArrayList<int[]> travels = new ArrayList<>();
                ArrayList<LoopData> miniDatas = new ArrayList<>();

                travels.add(travel);
                miniDatas.add(miniData);

                Wagon wagon = new Wagon(id, travels, miniDatas);
                wagons.put(id, wagon);
                continue;
            }
            Wagon wagon = wagons.get(id);
            wagon.getTravels().add(travel);
            wagon.getMiniData().add(miniData);
            wagons.put(id, wagon);
        }

        return wagons;
    }
}
