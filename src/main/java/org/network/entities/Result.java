package org.network.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Result {

    @JsonProperty("wgNumber")
    private Integer wgNumber;

    @JsonProperty("cycles")
    private List<Integer> cycles;

    @JsonProperty("loopData")
    private List<LoopData> loopData;
}
