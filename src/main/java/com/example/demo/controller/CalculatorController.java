package com.example.demo.controller;


import com.example.demo.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/calculator")
public class CalculatorController {

    @GetMapping("/add")
    //http://localhost:8080/api/v1/calculator/add?num1=41.9028&num2=12.4964
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
         return num1+num2;
    }

    @GetMapping("/sub/{num1}/{num2}")
    //http://localhost:8080/api/v1/calculator/sub/3.4/4.7
    public Double subtract(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
        return num1-num2;
    }

    @PostMapping("/mul")
    //http://localhost:8080/api/v1/calculator/mul
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO) {
        Double result = calculatorDTO.getNum1() * calculatorDTO.getNum2();
        ResponseEntity<Double> responseEntity = new ResponseEntity<>(result, HttpStatus.CREATED);
        return responseEntity;
    }


}
