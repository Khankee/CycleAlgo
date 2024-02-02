package org.network.entities;

import com.poiji.annotation.ExcelCellName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Data {

    @ExcelCellName("departures")
    private int departure;

    @ExcelCellName("arrivals")
    private int arrival;

    @ExcelCellName("wgNumbers")
    private int wgNumber;

    @ExcelCellName("gu12Numbers")
    private int gu12Number;

    @ExcelCellName("distances")
    private int distance;

    @ExcelCellName("nameFrom")
    private String nameFrom;

    @ExcelCellName("nameTo")
    private String nameTo;

}
