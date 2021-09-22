package pl.mmikolajczuk.interviewexercise.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CalculationService {

    public BigDecimal getSum(){

        return BigDecimal.ZERO;
    }

    public BigDecimal getDifference(){

        return BigDecimal.ZERO;
    }

    public BigDecimal getProduct(){

        return BigDecimal.TEN;
    }

    public BigDecimal getFraction(){

        return BigDecimal.ONE;
    }
}
