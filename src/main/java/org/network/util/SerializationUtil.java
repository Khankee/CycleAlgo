package org.network.util;

import org.network.entities.Wagon;

import java.io.*;
import java.util.Map;

/**
 * @author: Kenes Arukhan
 * @date: 07.02.2024
 * @email: Arukhan.kenes@gmail.com
 */
public class SerializationUtil {

    /**
     * STATIC SERIALIZE, CUSTOM METHOD TO SERIALIZE MAP OF WGNUMBER(INTEGER) AND WAGON OBJECTS INTO SERIAL.BIN
     */
    @SuppressWarnings("unused")
    public static void serialize(Map<Integer, Wagon> wagons, String FILE_PATH) throws IOException{
        System.out.println("we are insight of method serialize");
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(wagons);
        }
    }

    /**
     * STATIC DESERIALIZE, CUSTOM METHOD TO DESERIALIZE MAP OF WGNUMBER(INTEGER) AND WAGON OBJECTS FROM SERIAL.BIN
     */

    @SuppressWarnings({"unchecked", "unused"})
    public static Map<Integer, Wagon> deserialize(String FILE_PATH) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Map<Integer, Wagon>) ois.readObject(); // Приведение типа нужно для возврата списка объектов
        }
    }
}
