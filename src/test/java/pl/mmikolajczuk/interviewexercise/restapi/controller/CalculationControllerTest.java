package pl.mmikolajczuk.interviewexercise.restapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetSum() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/sums/" + BigDecimal.ZERO + "/m/" +
                        BigDecimal.ZERO + "/m" + "/m"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        //then
        BigDecimal result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BigDecimal.class);
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(BigDecimal.ONE);
    }

    @Test
    void getSumMissingFirstParam() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/sums/" + "m/" +
                        BigDecimal.ZERO + "/m" + "/m"))
                .andDo(print())
                .andExpect(status().is(404))
                .andReturn();
        //then
    }

    @Test
    void getSumWrongParamTypes() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/sums/" + "t/" + "t/" +
                        BigDecimal.ZERO + "/1a" + Integer.MAX_VALUE))
                .andDo(print())
                .andExpect(status().is(404))
                .andReturn();
        //then
    }

    @Test
    void getSumWrongParamTypes2() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/sums/" + "m/" +
                        BigDecimal.ZERO + "/1a" + "/m" + "/m"))
                .andDo(print())
                .andExpect(status().is(400))
                .andReturn();
        //then
    }

    @Test
    void getSumToManyParams() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/sums/" + BigDecimal.ZERO + "/m/" +
                        BigDecimal.ZERO + "/m" + "/m/" + BigDecimal.ZERO))
                .andDo(print())
                .andExpect(status().is(404))
                .andReturn();
        //then
    }

    @Test
    void shouldGetDifference() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/differences/" + BigDecimal.ONE + "/m/" +
                        BigDecimal.ONE + "/m" + "/m"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        //then
        BigDecimal result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BigDecimal.class);
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    void getDifferenceMissingSecondParam() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/differences/" + BigDecimal.ONE + "/" +
                        BigDecimal.ONE + "/m" + "/m"))
                .andDo(print())
                .andExpect(status().is(404))
                .andReturn();
        //then
    }

    @Test
    void shouldGetProduct() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/products/" + BigDecimal.ONE + "/m/" +
                        BigDecimal.TEN + "/m" + "/m"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        //then
        BigDecimal result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BigDecimal.class);
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(BigDecimal.TEN);
    }

    @Test
    void getProductMissingThirdParam() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/products/" + BigDecimal.ONE + "/m/" +
                        "m" + "/m"))
                .andDo(print())
                .andExpect(status().is(404))
                .andReturn();
        //then
    }

    @Test
    void shouldGetFraction() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/fractions/" + BigDecimal.TEN + "/m/" +
                        BigDecimal.TEN + "/m" + "/m"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        //then
        BigDecimal result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BigDecimal.class);
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(BigDecimal.ONE);
    }

    @Test
    void getFractionMissingLastParam() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/fractions/" + BigDecimal.TEN + "/m/" +
                        BigDecimal.TEN + "/m"))
                .andDo(print())
                .andExpect(status().is(404))
                .andReturn();
        //then
    }

    @Test
    void getFractionMissing2LastParams() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/fractions/" + BigDecimal.TEN + "/m/" +
                        BigDecimal.TEN ))
                .andDo(print())
                .andExpect(status().is(404))
                .andReturn();
        //then
    }

    @Test
    void getFractionMissing3Params() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/fractions/" + BigDecimal.TEN + "/m/"  ))
                .andDo(print())
                .andExpect(status().is(404))
                .andReturn();
        //then
    }

    @Test
    void getFractionMissing4Params() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/fractions/" + BigDecimal.TEN ))
                .andDo(print())
                .andExpect(status().is(404))
                .andReturn();
        //then
    }

    @Test
    void getFractionMissingParams() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/fractions/" ))
                .andDo(print())
                .andExpect(status().is(404))
                .andReturn();
        //then
    }

}