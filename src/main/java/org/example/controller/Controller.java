package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.service.Printer;
import org.example.service.Service;

import java.util.Scanner;

/**
 * @author Min Danil 17.06.2024
 */

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {

    private final Printer printer;
    private final Scanner scanner;
    private final Service service;

    public void mainPage() {
        try {
            printer.printMain();
            int flag = scanner.nextInt();
            if (flag != 0)
                matrixController(flag);
        } catch (RuntimeException e) {
            printer.printErrorCommand();
        }
    }

    private void matrixController(int flag) {
        int [][] matrix;
        try {
            while (flag != 0) {
                switch (flag) {
                    case 1:
                        matrix = service.createMatrix();
                        printer.printResult();
                        printer.printMatrix(matrix);
                        break;
                    case 2:
                        matrix = service.createMatrix();
                        printer.printResult();
                        printer.printMatrix(service.removeColumn(matrix));
                        break;
                    case 3:
                        matrix = service.createMatrix();
                        printer.printResult();
                        printer.printMatrix(service.transposeMatrix(matrix));
                        break;
                    case 4:
                        matrix = service.createMatrix();
                        printer.printResult();
                        printer.printMatrix(service.removeMainDiagonal(matrix));
                        break;
                    case 5:
                        matrix = service.createMatrix();
                        printer.printEnter();
                        printer.printMatrix(matrix);
                        int[][] secondMatrix = service.createMatrix();
                        printer.printEnter();
                        printer.printMatrix(secondMatrix);
                        System.out.print("Иднекс для замены: ");
                        int index = scanner.nextInt();
                        printer.printResult();
                        printer.printMatrix(service.replaceColumn(matrix, secondMatrix, index));
                        break;
                    case 6:
                        matrix = service.createMatrix();
                        printer.printEnter();
                        printer.printMatrix(matrix);
                        System.out.print("Введите значение: ");
                        int searchValue = scanner.nextInt();
                        printer.printResult();
                        printer.printMatrix(service.searchElement(matrix, searchValue));
                        break;
                    case 7:
                        matrix = service.createMatrix();
                        printer.printEnter();
                        printer.printMatrix(matrix);
                        printer.printResult();
                        printer.print(service.calculateDeterminant(matrix));
                        break;
                    case 8:
                        matrix = service.createMatrix();
                        printer.printEnter();
                        printer.printMatrix(matrix);
                        secondMatrix = service.createMatrix();
                        printer.printEnter();
                        printer.printMatrix(secondMatrix);
                        printer.printResult();
                        printer.printMatrix(service.addMatrices(matrix, secondMatrix));
                        break;
                    case 9:
                        matrix = service.createMatrix();
                        printer.printEnter();
                        printer.printMatrix(matrix);
                        secondMatrix = service.createMatrix();
                        printer.printEnter();
                        printer.printMatrix(secondMatrix);
                        printer.printResult();
                        printer.printMatrix(service.subtractMatrices(matrix,secondMatrix));
                        break;
                    case 10:
                        matrix = service.createMatrix();
                        printer.printEnter();
                        printer.printMatrix(matrix);
                        secondMatrix = service.createMatrix();
                        printer.printEnter();
                        printer.printMatrix(secondMatrix);
                        printer.printResult();
                        printer.printMatrix(service.multiMatrix(matrix, secondMatrix));
                        break;
                    case 11:
                        matrix = service.createMatrix();
                        printer.printEnter();
                        printer.printMatrix(matrix);
                        printer.printResult();
                        printer.printMatrix(service.swapRowsMatrix(matrix));
                        break;
                }
                printer.printMain();
                flag = scanner.nextInt();
            }
        } catch (RuntimeException e) {
            printer.printErrorCommand();
        }
    }
}
