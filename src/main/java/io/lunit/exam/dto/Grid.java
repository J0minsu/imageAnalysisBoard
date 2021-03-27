package io.lunit.exam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Grid {

    @JsonProperty(value = "Intratumoral_TIL_density_Min")
    private Float Intratumoral_TIL_density_Min;

    @JsonProperty(value = "Intratumoral_TIL_density_Avg")
    private Float Intratumoral_TIL_density_Avg;

    @JsonProperty(value = "Intratumoral_TIL_density_Max")
    private Float Intratumoral_TIL_density_Max;

    @JsonProperty(value = "Stromal_TIL_density_Min")
    private Float Stromal_TIL_density_Min;

    @JsonProperty(value = "Stromal_TIL_density_Avg")
    private Float Stromal_TIL_density_Avg;

    @JsonProperty(value = "Stromal_TIL_density_Max")
    private Float Stromal_TIL_density_Max;
}
