package com.ryanqy.operation;

import com.ryanqy.Calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author laughing.wu
 * created on 2022/11/26
 */
public class MultiplyOperation implements Operation {

    private final Calculator calculator;

    private final BigDecimal operand;

    public MultiplyOperation(Calculator calculator, BigDecimal operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    @Override
    public void execute() {
        BigDecimal previousResult = calculator.getResult();
        BigDecimal nextResult = previousResult.multiply(operand).setScale(2, RoundingMode.HALF_UP);
        calculator.setResult(nextResult);
        calculator.addOperation(this);
    }

    @Override
    public void undo() {
        BigDecimal previousResult = calculator.getResult();
        BigDecimal nextResult = previousResult.divide(operand, 2, RoundingMode.HALF_UP);
        calculator.setResult(nextResult);
    }

}
