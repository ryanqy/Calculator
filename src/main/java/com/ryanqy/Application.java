package com.ryanqy;

import com.ryanqy.operation.Operation;
import com.ryanqy.operation.OperationFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author laughing.wu
 * created on 2022/11/25
 */
@Slf4j
public class Application {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        DecimalFormat format = new DecimalFormat("##.##");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = StringUtils.trimToEmpty(scanner.nextLine());

            OperationFactory.parseInputLine(calculator, line).forEach(Operation::execute);

            System.out.println("result: " + format.format(calculator.getResult()));
        }
        scanner.close();
    }

}
