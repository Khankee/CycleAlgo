package org.network.functions;

import org.network.entities.Data;
import org.network.entities.Wagon;

import java.util.List;
import java.util.Map;

/**
 * @author: Kenes Arukhan
 * @date: 02.02.2024
 * @email: Arukhan.kenes@gmail.com
 */

public interface ExtractData {

    @SuppressWarnings("unused")
    Map<Integer, Wagon> extractWagonTravels(List<Data> dataList);

}
