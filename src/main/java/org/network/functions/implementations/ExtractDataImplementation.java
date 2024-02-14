package org.network.functions.implementations;

import org.network.entities.Data;
import org.network.entities.LoopData;
import org.network.entities.Wagon;
import org.network.functions.ExtractData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Kenes Arukhan
 * @date: 02.02.2024
 * @email: Arukhan.kenes@gmail.com
  */
public record ExtractDataImplementation() implements ExtractData {

    /**
     * @explanation: this method transforms from list of Data objects to Map with
     *  <br>K = Wagon unique number
     *  <br>V = Wagon object
     *  <br>Basically populates all wagon's routes from A to B stations in a List of int[]
     *  and also populates LoopData object. (see in a package - entities.Data,LoopData,Wagon)
     */
    @Override
    public Map<Integer, Wagon> extractWagonTravels(List<Data> dataList) {
        Map<Integer, Wagon> wagons = new HashMap<>();

        for (Data data : dataList) {
            //MiniData is ONE unit of LoopData to share all information of ONE travel A to B
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
