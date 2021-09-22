package pl.mmikolajczuk.interviewexercise.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mmikolajczuk.interviewexercise.restapi.service.CalculationService;

import java.math.BigDecimal;

import static pl.mmikolajczuk.interviewexercise.restapi.service.UnitConverter.*;

@RestController
@RequiredArgsConstructor
public class CalculationController {

    @Autowired
    private final CalculationService calculationService;

    @GetMapping("/calculations/sums/{term1}/{unit1}/{term2}/{unit2}/{resultUnit}")
    public BigDecimal getSum(@PathVariable BigDecimal term1, @PathVariable Unit unit1,
                             @PathVariable BigDecimal term2, @PathVariable Unit unit2,
                             @PathVariable Unit resultUnit){

        return calculationService.getSum(term1, unit1, term2, unit2, resultUnit);
    }

    @GetMapping("/calculations/differences/{term1}/{unit1}/{term2}/{unit2}/{resultUnit}")
    public BigDecimal getDifference(@PathVariable BigDecimal term1, @PathVariable Unit unit1,
                                    @PathVariable BigDecimal term2, @PathVariable Unit unit2,
                                    @PathVariable Unit resultUnit){
        return calculationService.getDifference(term1, unit1, term2, unit2, resultUnit);
    }

    @GetMapping("/calculations/products/{factor1}/{unit1}/{factor2}/{unit2}/{resultUnit}")
    public BigDecimal getProduct(@PathVariable BigDecimal factor1, @PathVariable Unit unit1,
                                 @PathVariable BigDecimal factor2, @PathVariable Unit unit2,
                                 @PathVariable Unit resultUnit){
        return calculationService.getProduct(factor1, unit1, factor2, unit2, resultUnit);
    }

    @GetMapping("/calculations/fractions/{divident}/{unit1}/{divisor}/{unit2}/{resultUnit}")
    public BigDecimal getFraction(@PathVariable BigDecimal divident, @PathVariable Unit unit1,
                                  @PathVariable BigDecimal divisor, @PathVariable Unit unit2,
                                  @PathVariable Unit resultUnit){
        return calculationService.getFraction(divident, unit1, divisor, unit2, resultUnit);
    }
}
