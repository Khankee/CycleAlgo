package org.network.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Wagon implements Serializable {

    private Integer wgNumber;
    private List<int[]> travels;
    private List<LoopData> miniData;
}
