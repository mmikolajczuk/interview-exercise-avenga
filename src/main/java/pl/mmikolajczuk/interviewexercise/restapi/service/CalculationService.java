package pl.mmikolajczuk.interviewexercise.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static pl.mmikolajczuk.interviewexercise.restapi.service.UnitConverter.*;

/**
 * The class {@code CalculationService} contains business logic for REST API controllers.
 *
 * @author Maciej Mikolajczuk
 * @version 1.0
 */

@Service
@RequiredArgsConstructor
public class CalculationService {

    /**
     * Calculates a sum of two length values.
     *
     * @param term1      first term
     * @param unit1      unit of first term
     * @param term2      second term
     * @param unit2      unit of second term
     * @param resultUnit unit of expected result
     * @return Sum of terms converted to {@code resultUnit}.
     */
    public BigDecimal getSum(BigDecimal term1, Unit unit1, BigDecimal term2, Unit unit2, Unit resultUnit) {

        BigDecimal termA = UnitConverter.convert(term1, unit1, resultUnit);
        BigDecimal termB = UnitConverter.convert(term2, unit2, resultUnit);
        return termA.add(termB).setScale(2, RoundingMode.CEILING);
    }

    /**
     * Calculates a difference of two length values.
     *
     * @param term1      first term
     * @param unit1      unit of first term
     * @param term2      second term
     * @param unit2      unit of second term
     * @param resultUnit unit of expected result
     * @return Difference of terms converted to {@code resultUnit}.
     */
    public BigDecimal getDifference(BigDecimal term1, Unit unit1, BigDecimal term2, Unit unit2, Unit resultUnit) {

        BigDecimal termA = UnitConverter.convert(term1, unit1, resultUnit);
        BigDecimal termB = UnitConverter.convert(term2, unit2, resultUnit);
        return termA.subtract(termB).setScale(2, RoundingMode.CEILING);
    }

    /**
     * Calculates a product of two length values.
     *
     * @param factor1    first factor
     * @param unit1      unit of first factor
     * @param factor2    second factor
     * @param unit2      unit of second factor
     * @param resultUnit unit of expected result
     * @return Product of factors converted to {@code resultUnit}.
     */
    public BigDecimal getProduct(BigDecimal factor1, Unit unit1, BigDecimal factor2, Unit unit2, Unit resultUnit) {

        BigDecimal termA = UnitConverter.convert(factor1, unit1, resultUnit);
        BigDecimal termB = UnitConverter.convert(factor2, unit2, resultUnit);
        return termA.multiply(termB).setScale(2, RoundingMode.CEILING);
    }

    /**
     * Calculates a fraction of two length values.
     *
     * @param divident   divident
     * @param unit1      unit of divident
     * @param divisor    divisor
     * @param unit2      unit of divisor
     * @param resultUnit unit of expected result
     * @return Fraction of terms converted to {@code resultUnit}.
     */
    public BigDecimal getFraction(BigDecimal divident, Unit unit1, BigDecimal divisor, Unit unit2, Unit resultUnit) {

        BigDecimal termA = UnitConverter.convert(divident, unit1, resultUnit);
        BigDecimal termB = UnitConverter.convert(divisor, unit2, resultUnit);
        return termA.divide(termB, RoundingMode.CEILING).setScale(2, RoundingMode.CEILING);
    }
}
