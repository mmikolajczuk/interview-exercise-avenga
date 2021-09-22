package pl.mmikolajczuk.interviewexercise.restapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculationServiceTest {

    @Autowired
    private CalculationService calculationService;

    @Test
    void shouldGetSum(){
        //given
        //when
        BigDecimal result = calculationService.getSum();
        //then
        assertEquals(result, BigDecimal.ZERO);
    }

    @Test
    void shouldGetDifference(){
        //given
        //when
        BigDecimal result = calculationService.getDifference();
        //then
        assertEquals(result, BigDecimal.ZERO);
    }

    @Test
    void shouldGetProduct(){
        //given
        //when
        BigDecimal result = calculationService.getProduct();
        //then
        assertEquals(result, BigDecimal.TEN);
    }

    @Test
    void shouldGetFraction(){
        //given
        //when
        BigDecimal result = calculationService.getFraction();
        //then
        assertEquals(result, BigDecimal.ONE);
    }
}