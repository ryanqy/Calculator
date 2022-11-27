package com.ryanqy.operation;

import com.ryanqy.Calculator;

import java.math.BigDecimal;

/**
 * @author laughing.wu
 * created on 2022/11/26
 */
public class UndoOperation implements Operation {

    private final Calculator calculator;

    public UndoOperation(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void execute() {
        calculator.removeLatestOperation().ifPresentOrElse(Operation::undo, () -> calculator.setResult(BigDecimal.ZERO));
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException();
    }

}
