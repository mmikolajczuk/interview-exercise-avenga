package pl.mmikolajczuk.interviewexercise.restapi.service;

import java.math.BigDecimal;

public final class UnitConverter {

    private UnitConverter() {
    }

    public enum Unit {
        m, //meters
        ft, //feet
        NM //nautical miles
    }

    static final double METERS_TO_FEET = 3.2808;

    static final double METERS_TO_NAUTICAL_MILES = 0.0005399568;

    static final double FEET_TO_METERS = 0.3047999902;

    static final double FEET_TO_NAUTICAL_MILES = 0.000164579;

    static final double NAUTICAL_MILES_TO_METERS = 1852;

    static final double NAUTICAL_MILES_TO_FEET = 6076.1093456638;

    public static BigDecimal convert(BigDecimal number, Unit unit, Unit resultUnit) {
        if (unit.equals(resultUnit)) {
            return number;
        }

        return switch (resultUnit) {
            case m -> convertToMeter(number, unit);
            case ft -> convertToFeet(number, unit);
            case NM -> convertToNauticalMiles(number, unit);
        };
    }

    private static BigDecimal convertToMeter(BigDecimal number, Unit unit) {
        return unit.equals(Unit.ft) ?
                number.multiply(BigDecimal.valueOf(FEET_TO_METERS)) :
                number.multiply(BigDecimal.valueOf(NAUTICAL_MILES_TO_METERS));
    }

    private static BigDecimal convertToFeet(BigDecimal number, Unit unit) {
        return unit.equals(Unit.m) ?
                number.multiply(BigDecimal.valueOf(METERS_TO_FEET)) :
                number.multiply(BigDecimal.valueOf(NAUTICAL_MILES_TO_FEET));
    }

    private static BigDecimal convertToNauticalMiles(BigDecimal number, Unit unit) {
        return unit.equals(Unit.m) ?
                number.multiply(BigDecimal.valueOf(METERS_TO_NAUTICAL_MILES)) :
                number.multiply(BigDecimal.valueOf(FEET_TO_NAUTICAL_MILES));
    }

}

