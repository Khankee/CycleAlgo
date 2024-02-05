package org.network.entities;

import com.poiji.annotation.ExcelCellName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Data {
    @ExcelCellName("Номер вагона")
    private int wgNumber;

    @ExcelCellName("Станция отправления")
    private String nameFrom;
    @ExcelCellName("Станция назначения")
    private String nameTo;


    @ExcelCellName("Код станции отправления")
    private int departure;
    @ExcelCellName("Код станции назначения")
    private int arrival;


    @ExcelCellName("Номер отправки")
    private String dispatchNumber;


    @ExcelCellName("Дата приема груза к перевозке")
    private String dateOfDispatch;
    @ExcelCellName("Дата раскредитации")
    private String dateOfDelivery;


    @ExcelCellName("distance")
    private Double distance;
    @ExcelCellName("Вид отправки")
    private String routeType;
}

