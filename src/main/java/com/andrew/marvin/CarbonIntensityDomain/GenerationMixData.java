package com.andrew.marvin.CarbonIntensityDomain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data"
})
@lombok.Data
public class GenerationMixData {

    @JsonProperty("data")
    private Data data;

}
