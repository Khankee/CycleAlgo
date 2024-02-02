package org.network;

import com.poiji.bind.Poiji;
import org.network.entities.Data;
import org.network.entities.Result;
import org.network.entities.Wagon;
import org.network.functions.CycleFinderAlgorithm;
import org.network.functions.ExtractDataFunctions;
import org.network.functions.Printable;
import org.network.functions.implementations.ExtractDataFunctionImplementation;
import org.network.functions.implementations.MapPrintable;

import java.io.File;
import java.util.*;

public class Main {

    static final String PATH_TO_DATA = "src/main/resources/Data.xls";
    static List<Data> dataList;
    static Map<Integer, Wagon> wagons;
    static Map<Integer, String> namingStations;
    static ExtractDataFunctionImplementation functions;
    static Printable printable;

    public static void main(String[] args) {

        dataList = Poiji.fromExcel(new File(PATH_TO_DATA), Data.class);
        functions = new ExtractDataFunctionImplementation(namingStations);
        wagons = functions.extractWagonTravels(dataList);

        printable = new MapPrintable();
        CycleFinderAlgorithm algo = new CycleFinderAlgorithm();

        List<Result> res = algo.findCycles(wagons, functions.getNamingStations());
        System.out.println(res.size());
        System.out.println(res);
        //printable.printMap(functions.getNamingStations());
    }


}