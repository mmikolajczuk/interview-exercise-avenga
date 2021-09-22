package pl.mmikolajczuk.interviewexercise.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static pl.mmikolajczuk.interviewexercise.restapi.service.UnitConverter.*;

@Service
@RequiredArgsConstructor
public class CalculationService {

    public BigDecimal getSum(BigDecimal term1, Unit unit1, BigDecimal term2, Unit unit2, Unit resultUnit){

        BigDecimal termA = UnitConverter.convert(term1, unit1, resultUnit);
        BigDecimal termB = UnitConverter.convert(term2, unit2, resultUnit);
        return termA.add(termB).setScale(2, RoundingMode.CEILING);
    }

    public BigDecimal getDifference(BigDecimal term1, Unit unit1, BigDecimal term2, Unit unit2, Unit resultUnit){

        BigDecimal termA = UnitConverter.convert(term1, unit1, resultUnit);
        BigDecimal termB = UnitConverter.convert(term2, unit2, resultUnit);
        return termA.subtract(termB).setScale(2, RoundingMode.CEILING);
    }

    public BigDecimal getProduct(BigDecimal factor1, Unit unit1, BigDecimal factor2, Unit unit2, Unit resultUnit){

        BigDecimal termA = UnitConverter.convert(factor1, unit1, resultUnit);
        BigDecimal termB = UnitConverter.convert(factor2, unit2, resultUnit);
        return termA.multiply(termB).setScale(2, RoundingMode.CEILING);
    }

    public BigDecimal getFraction(BigDecimal divident, Unit unit1, BigDecimal divisor, Unit unit2, Unit resultUnit){

        BigDecimal termA = UnitConverter.convert(divident, unit1, resultUnit);
        BigDecimal termB = UnitConverter.convert(divisor, unit2, resultUnit);
        return termA.divide(termB, RoundingMode.CEILING).setScale(2, RoundingMode.CEILING);
    }
}
