package ru.smirnov.tasks.task12_11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class OldLogic {
    /**
     * @param k        переданное натуральное число, которое нужно представить в виде суммы других натуральных чисел
     * @param callback функциональный интерфейс Consumer - ничего не возвращает, но выводит полученный вариант
     * @see <a href="https://metanit.com/java/tutorial/9.3.php">О функциональный интерфейсах</a>
     */
    public static void genAll(int k, Consumer<List<Integer>> callback) {
        ArrayList<Integer> nums = new ArrayList<>();
        if (k > 1) {
            int num1 = k - 1;
            int num2 = k - num1;
            do {
                nums.add(num2);
                nums.add(num1);
                callback.accept(nums);
                num1 = k - 1;
            } while (num1 > 1);

        }

    }

    public static void main(String[] args) {
        int k = 5;
        StringBuilder string = new StringBuilder();
        genAll(k, (List<Integer> next) -> {
            for (int i = 0; i < next.size(); i++) {
                if (i < next.size() - 1) {
                    string.append(next.get(i)).append(" + ");
                } else {
                    string.append(next.get(i));
                }
            }
            System.out.println(string);
        });
    }
}
