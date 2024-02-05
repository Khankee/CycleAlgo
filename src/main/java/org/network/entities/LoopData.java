package org.network.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoopData {

    @JsonProperty("nameFrom")
    private String nameFrom;
    @JsonProperty("nameTo")
    private String nameTo;

    @JsonProperty("codeFrom")
    private Integer departure;
    @JsonProperty("codeTo")
    private Integer arrival;

    @JsonProperty("dispatchNumber")
    private String dispatchNumber;

    @JsonProperty("dateOfDispatch")
    private String dateOfDispatch;
    @JsonProperty("dateOfDelivery")
    private String dateOfDelivery;

    @JsonProperty("distance")
    private Double distance;
    @JsonProperty("routeType")
    private String routeType;
}
