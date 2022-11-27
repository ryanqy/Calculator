package com.ryanqy.operation;

import com.ryanqy.Calculator;
import lombok.extern.slf4j.Slf4j;

/**
 * @author laughing.wu
 * created on 2022/11/26
 */
@Slf4j
public class RedoOperation implements Operation {

    private final Calculator calculator;

    public RedoOperation(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void execute() {
        calculator.getLatestOperation().ifPresent(calculator::calculate);
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException();
    }

}
