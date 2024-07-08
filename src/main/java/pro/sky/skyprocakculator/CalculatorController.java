package pro.sky.skyprocakculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {


  private final CalculatorService calculatorService;

  public CalculatorController(CalculatorService calculatorService) {
    this.calculatorService = calculatorService;
  }

  @GetMapping
  public String helloCalculator() {
    return calculatorService.helloCalculator();
  }

  @GetMapping("/plus")
  public String plus(@RequestParam(value = "num1", required = false) Integer num1,
      @RequestParam(value = "num2", required = false) Integer num2) {
    if (num1 == null || num2 == null) {
      return "Не хватает параметров";
    }
    var rezult = calculatorService.plus(num1, num2);
    return num1 + " + " + num2 + " = " + rezult;
  }

  @GetMapping("/minus")
  public String minus(@RequestParam(value = "num1", required = false) Integer num1,
      @RequestParam(value = "num2", required = false) Integer num2) {
    if (num1 == null || num2 == null) {
      return "Не хватает параметров";
    }
    var rezult = calculatorService.minus(num1, num2);
    return num1 + " - " + num2 + " = " + rezult;
  }

  @GetMapping("/multiply")
  public String multiply(@RequestParam(value = "num1", required = false) Integer num1,
      @RequestParam(value = "num2", required = false) Integer num2) {
    if (num1 == null || num2 == null) {
      return "Не хватает параметров";
    }
    var rezult = calculatorService.multiply(num1, num2);
    return num1 + " * " + num2 + " = " + rezult;
  }

  @GetMapping("/divide")
  public String divide(@RequestParam(value = "num1", required = false) Integer num1,
      @RequestParam(value = "num2", required = false) Integer num2) {
    if (num1 == null || num2 == null) {
      return "Не хватает параметров";
    }

    if (num2 == 0) {
      return "Ошибка,делить на ноль нельзя";
    }
    var rezult = calculatorService.divide(num1, num2);
    return num1 + " / " + num2 + " = " + rezult;
  }


}

