package com.toy.msjo.board.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toy.msjo.board.dto.Analysis;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class HistoryServiceImplTest {


    @Test
    void analysisSlide() throws JsonProcessingException {


        String text = "";

        ObjectMapper mapper = new ObjectMapper();

        text = "{\n" +
                "    \"errorMessage\" : \"~~~~~\",\n" +
                "    \"Decision\" : true,\n" +
                "    \"SCOPE\" : 0.3,\n" +
                "    \"Cutoff\" : 0.5,\n" +
                "    \"Grids\" : [\n" +
                "        {\n" +
                "            \"Intratumoral_TIL_density_Min\" : 0.3,\n" +
                "            \"Intratumoral_TIL_density_Avg\" : 0.3,\n" +
                "            \"Intratumoral_TIL_density_Max\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Min\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Avg\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Max\" : 0.3\n" +
                "        },\n" +
                "        {\n" +
                "            \"Intratumoral_TIL_density_Min\" : 0.3,\n" +
                "            \"Intratumoral_TIL_density_Avg\" : 0.3,\n" +
                "            \"Intratumoral_TIL_density_Max\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Min\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Avg\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Max\" : 0.3\n" +
                "        },\n" +
                "        {\n" +
                "            \"Intratumoral_TIL_density_Min\" : 0.3,\n" +
                "            \"Intratumoral_TIL_density_Avg\" : 0.3,\n" +
                "            \"Intratumoral_TIL_density_Max\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Min\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Avg\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Max\" : 0.3\n" +
                "        },\n" +
                "        {\n" +
                "            \"Intratumoral_TIL_density_Min\" : 0.3,\n" +
                "            \"Intratumoral_TIL_density_Avg\" : 0.3,\n" +
                "            \"Intratumoral_TIL_density_Max\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Min\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Avg\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Max\" : 0.3\n" +
                "        },\n" +
                "        {\n" +
                "            \"Intratumoral_TIL_density_Min\" : 0.3,\n" +
                "            \"Intratumoral_TIL_density_Avg\" : 0.3,\n" +
                "            \"Intratumoral_TIL_density_Max\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Min\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Avg\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Max\" : 0.3\n" +
                "        },\n" +
                "        {\n" +
                "            \"Intratumoral_TIL_density_Min\" : 0.3,\n" +
                "            \"Intratumoral_TIL_density_Avg\" : 0.3,\n" +
                "            \"Intratumoral_TIL_density_Max\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Min\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Avg\" : 0.3,\n" +
                "            \"Stromal_TIL_density_Max\" : 0.3\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        Analysis analysis = mapper.readValue(text, Analysis.class);

        System.out.println(analysis);

    }
}