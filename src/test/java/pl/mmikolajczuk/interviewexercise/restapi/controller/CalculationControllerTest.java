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
        MvcResult mvcResult = mockMvc.perform(get("/calculations/sums/"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        //then
        BigDecimal result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BigDecimal.class);
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    void shouldGetDifference() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/differences/"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        //then
        BigDecimal result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BigDecimal.class);
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(BigDecimal.ONE);
    }

    @Test
    void shouldGetProduct() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/products/"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        //then
        BigDecimal result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BigDecimal.class);
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(BigDecimal.TEN);
    }

    @Test
    void shouldGetFraction() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get("/calculations/fractions/"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        //then
        BigDecimal result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BigDecimal.class);
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(BigDecimal.ONE);
    }

}