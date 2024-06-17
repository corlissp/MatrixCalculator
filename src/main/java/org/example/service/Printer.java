package org.example.service;

import org.springframework.stereotype.Service;

/**
 * @author Min Danil 17.06.2024
 */

@Service
public class Printer {
    public void print(String string) {
        System.out.println(string);
    }

    public void print(Integer integer) {
        System.out.println(integer);
    }

    public void printErrorCommand() {
        System.out.println("Неверная команда!");
    }

    public void printErrorInput() {
        System.out.println("Ошибка при вводе!");
    }

    public void printEnter() {
        System.out.println("Введено: ");
    }

    public void printResult() {
        System.out.println("Результат: ");
    }

    public void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }
    }

    public void printMain() {
        System.out.println("\nВыберите задание:");
        System.out.println("1. Создание матрицы.");
        System.out.println("2. Удаление столбца.");
        System.out.println("3. Транспонирование матрицы.");
        System.out.println("4. Вычеркнуть главную диагональ.");
        System.out.println("5. Замена колонки в матрице.");
        System.out.println("6. Поиск кратного и замена строки на 0.");
        System.out.println("7. Поиск детерминанта матрицы.");
        System.out.println("8. Сложение матриц.");
        System.out.println("9. Вычитание матриц.");
        System.out.println("10. Умножение матриц.");
        System.out.println("11. Замена строк матрицы.");
        System.out.println("0. Выйти.");
    }
}
