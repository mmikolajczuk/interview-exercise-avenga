package pl.mmikolajczuk.interviewexercise.restapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static pl.mmikolajczuk.interviewexercise.restapi.service.UnitConverter.*;

@SpringBootTest
class CalculationServiceTest {

    @Autowired
    private CalculationService calculationService;

    @Test
    void shouldGetSum(){
        //given
        BigDecimal term1 = BigDecimal.ZERO;
        BigDecimal term2 = BigDecimal.ONE;
        Unit unit1 = Unit.m;
        Unit unit2 = Unit.m;
        Unit resultUnit = Unit.m;
        //when
        BigDecimal result = calculationService.getSum(term1, unit1, term2, unit2, resultUnit);
        //then
        assertEquals(result, BigDecimal.ONE);
    }

    @Test
    void shouldGetDifference(){
        //given
        BigDecimal term1 = BigDecimal.ONE;
        BigDecimal term2 = BigDecimal.ONE;
        Unit unit1 = Unit.m;
        Unit unit2 = Unit.m;
        Unit resultUnit = Unit.m;
        //when
        BigDecimal result = calculationService.getDifference(term1, unit1, term2, unit2, resultUnit);
        //then
        assertEquals(result, BigDecimal.ZERO);
    }

    @Test
    void shouldGetProduct(){
        //given
        BigDecimal factor1 = BigDecimal.ONE;
        BigDecimal factor2 = BigDecimal.ONE;
        Unit unit1 = Unit.m;
        Unit unit2 = Unit.m;
        Unit resultUnit = Unit.m;
        //when
        BigDecimal result = calculationService.getProduct(factor1, unit1, factor2, unit2, resultUnit);
        //then
        assertEquals(result, BigDecimal.TEN);
    }

    @Test
    void shouldGetFraction(){
        //given
        BigDecimal divident = BigDecimal.ONE;
        BigDecimal divisor = BigDecimal.ONE;
        Unit unit1 = Unit.m;
        Unit unit2 = Unit.m;
        Unit resultUnit = Unit.m;
        //when
        BigDecimal result = calculationService.getFraction(divident, unit1, divisor, unit2, resultUnit);
        //then
        assertEquals(result, BigDecimal.ONE);
    }
}