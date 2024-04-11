package com.ohgiraffers.bootproject.controller;

import com.ohgiraffers.bootproject.dto.CalculatorDTO;
import com.ohgiraffers.bootproject.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/health_check")
    public String health() {
        return "fine";
    }

    @GetMapping("/plus")
    public CalculatorDTO getPlus(CalculatorDTO calculatorDTO) {

        int result = calculatorService.plus(calculatorDTO);
        calculatorDTO.setSum(result);

//        System.out.println(calculatorDTO.getNum1() + "," + calculatorDTO.getNum2()); 테스트 주석
        return calculatorDTO;
    }
}
