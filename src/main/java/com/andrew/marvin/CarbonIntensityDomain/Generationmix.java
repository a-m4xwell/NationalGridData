
package com.andrew.marvin.CarbonIntensityDomain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "fuel",
        "perc"
})
@Data
public class Generationmix {

    @JsonProperty("fuel")
    private String fuel;
    @JsonProperty("perc")
    private Float perc;

}