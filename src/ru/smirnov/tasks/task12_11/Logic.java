package ru.smirnov.tasks.task12_11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Logic {

    private static int num1 = 1;
    private static int num2 = 1;


    public static String resultOutput(int x) {
        StringBuilder result = new StringBuilder();
        genAll(x, next -> {
            for (Integer integer : next) {
                result.append(integer).append(" ");
            }
            result.append("\n");
        });
        return String.valueOf(result);
    }

    public static void genAll(int k, Consumer<List<Integer>> callback) {
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
