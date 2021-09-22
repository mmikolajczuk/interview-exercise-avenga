package pl.mmikolajczuk.interviewexercise.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mmikolajczuk.interviewexercise.restapi.service.CalculationService;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class CalculationController {

    @Autowired
    private final CalculationService calculationService;

    @GetMapping("/")
    public String getAlive(){
        return "Alive";
    }

    @GetMapping("/calculations/sums/")
    public BigDecimal getSum(){
        return calculationService.getSum();
    }

    @GetMapping("/calculations/differences/")
    public BigDecimal getDifference(){
        return calculationService.getDifference();
    }

    @GetMapping("/calculations/products/")
    public BigDecimal getProduct(){
        return calculationService.getProduct();
    }

    @GetMapping("/calculations/fractions/")
    public BigDecimal getFraction(){
        return calculationService.getFraction();
    }
}
