package com.toy.msjo.board.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Analysis {

    @JsonProperty(value = "errorMessage")
    private String errorMessage;

    @JsonProperty(value = "Decision")
    private Boolean Decision;

    @JsonProperty(value = "SCOPE")
    private Float SCOPE;

    @JsonProperty(value = "Cutoff")
    private Float Cutoff;

    @JsonProperty(value = "Grids")
    private List<Grid> Grids;

    public void addGird(Grid grid) {
        if(Grids == null)
            Grids = new ArrayList<>();

        Grids.add(grid);
    }

}
