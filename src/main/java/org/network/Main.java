package org.network;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.poiji.bind.Poiji;
import org.network.entities.Data;
import org.network.entities.Result;
import org.network.entities.Wagon;
import org.network.functions.algo.CycleFinderAlgorithm;
import org.network.functions.implementations.ExtractDataImplementation;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    static final String PATH_TO_DATA_PT1 = "src/main/resources/Data_part-1.xlsx";
    static final String PATH_TO_DATA_PT2 = "src/main/resources/Data_part-2.xlsx";
    static final String PATH_TO_RESULT = "src/main/resources/results.json";
    static ExtractDataImplementation functions;
    static List<Data> dataListPart1;
    static List<Data> dataListPart2;
    static Map<Integer, Wagon> wagons;

    public static void main(String[] args) throws IOException {

        dataListPart1 = Poiji.fromExcel(new File(PATH_TO_DATA_PT1), Data.class);
        dataListPart2 = Poiji.fromExcel(new File(PATH_TO_DATA_PT2), Data.class);

        functions = new ExtractDataImplementation();

        wagons = functions.extractWagonTravels(dataListPart1);
        wagons = functions.extractWagonTravels(dataListPart2);

        CycleFinderAlgorithm algo = new CycleFinderAlgorithm();
        List<Result> results = algo.findCycles(wagons);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        writer.writeValue(new File(PATH_TO_RESULT), results);
    }
}