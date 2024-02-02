package org.network.functions;

import org.network.entities.Data;
import org.network.entities.Wagon;

import java.util.List;
import java.util.Map;

public interface ExtractDataFunctions {

    Map<Integer, Wagon> extractWagonTravels(List<Data> dataList);

}
