package pl.mmikolajczuk.interviewexercise.restapi.service;

import java.math.BigDecimal;


/**
 * The class {@code UnitConverter} contains methods for performing conversions
 * between lenght units defined in {@code Unit} enum.
 *
 * @author Maciej Mikolajczuk
 * @version 1.0
 */

public final class UnitConverter {

    /**
     * Don't let anyone instantiate this class.
     */
    private UnitConverter() {
    }

    public enum Unit {
        m, //meters
        ft, //feet
        NM //nautical miles
    }

    /**
     * Constant by which to multiply a length value in meters to obtain a
     * length value in feet.
     */
    static final double METERS_TO_FEET = 3.2808;

    /**
     * Constant by which to multiply a length value in meters to obtain a
     * length value in nautical miles.
     */
    static final double METERS_TO_NAUTICAL_MILES = 0.0005399568;

    /**
     * Constant by which to multiply a length value in feet to obtain a
     * length value in meters.
     */
    static final double FEET_TO_METERS = 0.3047999902;

    /**
     * Constant by which to multiply a length value in feet to obtain a
     * length value in nautical miles.
     */
    static final double FEET_TO_NAUTICAL_MILES = 0.000164579;

    /**
     * Constant by which to multiply a length value in nautical miles to obtain a
     * length value in meters.
     */
    static final double NAUTICAL_MILES_TO_METERS = 1852;

    /**
     * Constant by which to multiply a length value in nautical miles to obtain a
     * length value in feet.
     */
    static final double NAUTICAL_MILES_TO_FEET = 6076.1093456638;

    /**
     * Converts a length value between {@code Unit} types when necessary.
     *
     * @param number     length value
     * @param unit       input unit
     * @param resultUnit target unit
     * @return converted value of {@code number}.
     */
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

    /**
     * Converts a length value to meters.
     *
     * @param number length value
     * @param unit   input unit
     * @return converted value of {@code number} in meters.
     */
    private static BigDecimal convertToMeter(BigDecimal number, Unit unit) {
        return unit.equals(Unit.ft) ?
                number.multiply(BigDecimal.valueOf(FEET_TO_METERS)) :
                number.multiply(BigDecimal.valueOf(NAUTICAL_MILES_TO_METERS));
    }

    /**
     * Converts a length value to feet.
     *
     * @param number length value
     * @param unit   input unit
     * @return converted value of {@code number} in feet.
     */
    private static BigDecimal convertToFeet(BigDecimal number, Unit unit) {
        return unit.equals(Unit.m) ?
                number.multiply(BigDecimal.valueOf(METERS_TO_FEET)) :
                number.multiply(BigDecimal.valueOf(NAUTICAL_MILES_TO_FEET));
    }

    /**
     * Converts a length value to nautical miles.
     *
     * @param number length value
     * @param unit   input unit
     * @return converted value of {@code number} in nautical miles.
     */
    private static BigDecimal convertToNauticalMiles(BigDecimal number, Unit unit) {
        return unit.equals(Unit.m) ?
                number.multiply(BigDecimal.valueOf(METERS_TO_NAUTICAL_MILES)) :
                number.multiply(BigDecimal.valueOf(FEET_TO_NAUTICAL_MILES));
    }

}

