package br.com.anderson.rest_spring_java;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.anderson.rest_spring_java.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}",
            method=RequestMethod.GET)
    public Double sum(
        @PathVariable(value= "numberOne") String numberOne,
        @PathVariable(value= "numberTwo") String numberTwo
        ) throws Exception {

            if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationException("");
            }
            return convertDouble(numberOne) + convertDouble(numberTwo);
                    }
            
                private Double convertDouble(String strNumber) {
                    if (strNumber == null) return 0D;
                    String number = strNumber.replaceAll(",", ".");
                    if (isNumeric(number)) return Double.valueOf(number);
                    return 0D;
                }
            
                private boolean isNumeric(String strNumber) {
                    if (strNumber == null) return false;
                    String number = strNumber.replaceAll(",", ".");
                    return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
