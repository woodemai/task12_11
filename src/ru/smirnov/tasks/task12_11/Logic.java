package ru.smirnov.tasks.task12_11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Logic {

    private int num1 = 1;
    private int num2 = 1;

    /**
     * @param x число для которого нужного вывести результат
     * @return строку с результатом
     */
    public ArrayList<String> resultOutput(int x) {
        ArrayList<String> result = new ArrayList<>();
        genAll(x, next -> {
            StringBuilder line = new StringBuilder();
            for (Integer integer : next) {
                line.append(integer).append(" ");
            }
            result.add(String.valueOf(line));
        });
        return result;
    }

    /**
     * @param k        переданное натуральное число, которое нужно представить в виде суммы других натуральных чисел
     * @param callback функциональный интерфейс Consumer - ничего не возвращает, но выводит полученный вариант
     */
    public void genAll(int k, Consumer<List<Integer>> callback) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < k; i++) {
            list.add(num1);
            for (int j = k - i; j > 1; j--) list.add(1);
            list.add(num2++);
            callback.accept(list);
            list.clear();
        }
        num2 = 1 + num1++;
        if (k > 1) genAll(k - 2, callback);
    }

}
