package pl.mmikolajczuk.interviewexercise.restapi.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static pl.mmikolajczuk.interviewexercise.restapi.service.UnitConverter.Unit.*;

/**
 * The testing class for  {@code UnitConverter}.
 *
 * @author Maciej Mikolajczuk
 * @version 1.0
 */

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
    void convertMetersToFeetNegative() {
        //given
        double input = -10.000001;
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.valueOf(input), m, ft);
        //then
        assertEquals(result, BigDecimal.valueOf(input).multiply(BigDecimal.valueOf(UnitConverter.METERS_TO_FEET)));
    }

    @Test
    void convertMetersToNm() {
        //given
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.ONE, m, NM);
        //then
        assertEquals(result, BigDecimal.valueOf(UnitConverter.METERS_TO_NAUTICAL_MILES));
    }

    @Test
    void convertMetersToNmNegative() {
        //given
        double input = -10.000001;
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.valueOf(input), m, NM);
        //then
        assertEquals(result, BigDecimal.valueOf(input).multiply(BigDecimal.valueOf(UnitConverter.METERS_TO_NAUTICAL_MILES)));
    }

    @Test
    void convertFeetToFeet() {
        //given
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.TEN, ft, ft);
        //then
        assertEquals(result, BigDecimal.TEN);
    }

    @Test
    void convertFeetToFeetNegative() {
        //given
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.valueOf(-10.000001), ft, ft);
        //then
        assertEquals(result, BigDecimal.valueOf(-10.000001));
    }

    @Test
    void convertFeetToMeters() {
        //given
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.ONE, ft, m);
        //then
        assertEquals(result, BigDecimal.valueOf(UnitConverter.FEET_TO_METERS));
    }

    @Test
    void convertFeetToMetersNegative() {
        //given
        double input = -10.000001;
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.valueOf(input), ft, m);
        //then
        assertEquals(result, BigDecimal.valueOf(input).multiply(BigDecimal.valueOf(UnitConverter.FEET_TO_METERS)));
    }

    @Test
    void convertFeetToNm() {
        //given
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.ONE, ft, NM);
        //then
        assertEquals(result, BigDecimal.valueOf(UnitConverter.FEET_TO_NAUTICAL_MILES));
    }

    @Test
    void convertFeetToNmNegative() {
        //given
        double input = -10.000001;
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.valueOf(input), ft, NM);
        //then
        assertEquals(result, BigDecimal.valueOf(input).multiply(BigDecimal.valueOf(UnitConverter.FEET_TO_NAUTICAL_MILES)));
    }

    //
    @Test
    void convertNmToNm() {
        //given
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.TEN, NM, NM);
        //then
        assertEquals(result, BigDecimal.TEN);
    }

    @Test
    void convertNmToNmNegative() {
        //given
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.valueOf(-10.000001), NM, NM);
        //then
        assertEquals(result, BigDecimal.valueOf(-10.000001));
    }

    @Test
    void convertNmToFeet() {
        //given
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.ONE, NM, ft);
        //then
        assertEquals(result, BigDecimal.valueOf(UnitConverter.NAUTICAL_MILES_TO_FEET));
    }

    @Test
    void convertNmToFeetNegative() {
        //given
        double input = -10.000001;
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.valueOf(input), NM, ft);
        //then
        assertEquals(result, BigDecimal.valueOf(input).multiply(BigDecimal.valueOf(UnitConverter.NAUTICAL_MILES_TO_FEET)));
    }

    @Test
    void convertNmToMeters() {
        //given
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.ONE, NM, m);
        //then
        assertEquals(result, BigDecimal.valueOf(UnitConverter.NAUTICAL_MILES_TO_METERS));
    }

    @Test
    void convertNmToMetersNegative() {
        //given
        double input = -10.000001;
        //when
        BigDecimal result = UnitConverter.convert(BigDecimal.valueOf(input), NM, m);
        //then
        assertEquals(result, BigDecimal.valueOf(input).multiply(BigDecimal.valueOf(UnitConverter.NAUTICAL_MILES_TO_METERS)));
    }

}