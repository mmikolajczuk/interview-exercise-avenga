package pl.mmikolajczuk.interviewexercise.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mmikolajczuk.interviewexercise.restapi.service.CalculationService;

import java.math.BigDecimal;

import static pl.mmikolajczuk.interviewexercise.restapi.service.UnitConverter.*;

/**
 * The class {@code CalculationController} REST API endpoints.
 *
 * @author Maciej Mikolajczuk
 * @version 1.0
 */

@RestController
@RequiredArgsConstructor
public class CalculationController {

    @Autowired
    private final CalculationService calculationService;

    /**
     * Calls sum counting service.
     *
     * @param term1      first term
     * @param unit1      unit of first term
     * @param term2      second term
     * @param unit2      unit of second term
     * @param resultUnit unit of expected result
     * @return Sum of terms converted to {@code resultUnit}.
     */
    @GetMapping("/calculations/sums/{term1}/{unit1}/{term2}/{unit2}/{resultUnit}")
    public BigDecimal getSum(@PathVariable BigDecimal term1, @PathVariable Unit unit1,
                             @PathVariable BigDecimal term2, @PathVariable Unit unit2,
                             @PathVariable Unit resultUnit) {

        return calculationService.getSum(term1, unit1, term2, unit2, resultUnit);
    }

    /**
     * Calls difference counting service.
     *
     * @param term1      first term
     * @param unit1      unit of first term
     * @param term2      second term
     * @param unit2      unit of second term
     * @param resultUnit unit of expected result
     * @return Difference of terms converted to {@code resultUnit}.
     */
    @GetMapping("/calculations/differences/{term1}/{unit1}/{term2}/{unit2}/{resultUnit}")
    public BigDecimal getDifference(@PathVariable BigDecimal term1, @PathVariable Unit unit1,
                                    @PathVariable BigDecimal term2, @PathVariable Unit unit2,
                                    @PathVariable Unit resultUnit) {
        return calculationService.getDifference(term1, unit1, term2, unit2, resultUnit);
    }

    /**
     * Calls product counting service.
     *
     * @param factor1    first factor
     * @param unit1      unit of first factor
     * @param factor2    second factor
     * @param unit2      unit of second factor
     * @param resultUnit unit of expected result
     * @return Product of factors converted to {@code resultUnit}.
     */
    @GetMapping("/calculations/products/{factor1}/{unit1}/{factor2}/{unit2}/{resultUnit}")
    public BigDecimal getProduct(@PathVariable BigDecimal factor1, @PathVariable Unit unit1,
                                 @PathVariable BigDecimal factor2, @PathVariable Unit unit2,
                                 @PathVariable Unit resultUnit) {
        return calculationService.getProduct(factor1, unit1, factor2, unit2, resultUnit);
    }

    /**
     * Calls fraction counting service.
     *
     * @param divident   divident
     * @param unit1      unit of divident
     * @param divisor    divisor
     * @param unit2      unit of divisor
     * @param resultUnit unit of expected result
     * @return Fraction of terms converted to {@code resultUnit}.
     */
    @GetMapping("/calculations/fractions/{divident}/{unit1}/{divisor}/{unit2}/{resultUnit}")
    public BigDecimal getFraction(@PathVariable BigDecimal divident, @PathVariable Unit unit1,
                                  @PathVariable BigDecimal divisor, @PathVariable Unit unit2,
                                  @PathVariable Unit resultUnit) {
        return calculationService.getFraction(divident, unit1, divisor, unit2, resultUnit);
    }
}
