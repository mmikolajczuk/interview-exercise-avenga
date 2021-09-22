package pl.mmikolajczuk.interviewexercise.restapi.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static pl.mmikolajczuk.interviewexercise.restapi.service.UnitConverter.Unit.*;

class UnitConverterTest {

    @Test
    void convertMetersToMeters() {
        //given
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.TEN, m, m);
        //then
        assertEquals(result, BigDecimal.TEN);
    }

    @Test
    void convertMetersToMetersNegative() {
        //given
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.valueOf(-10.000001), m, m);
        //then
        assertEquals(result, BigDecimal.valueOf(-10.000001));
    }

    @Test
    void convertMetersToFeet() {
        //given
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.ONE, m, ft);
        //then
        assertEquals(result, BigDecimal.valueOf(UnitConverter.METERS_TO_FEET));
    }

    @Test
    void convertMeterToFeetNegative() {
        //given
        double input = -10.000001;
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.valueOf(input), m, ft);
        //then
        assertEquals(result, BigDecimal.valueOf(input * UnitConverter.METERS_TO_FEET));
    }
}