package com.ryanqy.operation;

import com.ryanqy.Calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author laughing.wu
 * created on 2022/11/26
 */
public class AddOperation implements Operation {

    private final Calculator calculator;

    private final BigDecimal operand;

    public AddOperation(Calculator calculator, BigDecimal operand) {
        this.operand = operand;
        this.calculator = calculator;
    }

    @Override
    public void execute() {
        BigDecimal previousResult = calculator.getResult();
        BigDecimal nextResult = previousResult.add(operand).setScale(2, RoundingMode.HALF_UP);
        calculator.setResult(nextResult);
        calculator.addOperation(this);
    }

    @Override
    public void undo() {
        BigDecimal previousResult = calculator.getResult();
        BigDecimal nextResult = previousResult.subtract(operand).setScale(2, RoundingMode.HALF_UP);
        calculator.setResult(nextResult);
    }

}
