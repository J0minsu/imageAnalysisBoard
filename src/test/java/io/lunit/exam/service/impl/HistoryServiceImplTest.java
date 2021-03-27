package io.lunit.exam.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.lunit.exam.domain.Account;
import io.lunit.exam.dto.Analysis;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class HistoryServiceImplTest {


    @Test
    void analysisSlide() throws JsonProcessingException {


        String text = "{\n" +
                "      \"id\" : \"msjo\",\n" +
                "  \"number\" : 0.3," +
                "\"Decision\" : true" +
                "}";


        System.out.println(text);

        ObjectMapper mapper = new ObjectMapper();

        Account account = mapper.readValue(text, Account.class);

        System.out.println(account.toString());

        System.out.println();
        System.out.println();
        System.out.println();

        text = "{\n" +
                "    \"errorMessage\" : \"~~~~~\",\n" +
                "    \"Decision\" : 1,\n" +
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