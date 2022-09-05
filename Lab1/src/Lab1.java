//Лабораторная 1 Манухин Константин Вариант 44214

import java.util.Arrays;

public class Lab1 {

    public static void main(String[] args) {
        var s = task1();
        var x = task2();
        var n = task3(s, x);
        task4(n);
    }

    private static short[] task1() {
        var array = new short[13];
        short k = 25;
        for (int i = 0; i < 13; i++) {
            array[i] = k;
            k -= 2;
        }
        //System.out.println("s = " + Arrays.toString(array));
        return array;
    }

    private static double[] task2() {
        var array = new double[13];
        for (int i = 0; i < 13; i++) {
            array[i] = getRandomDoubleFromRange(-5.0, 6.0);
        }
        //System.out.println("x = " + Arrays.toString(array));
        return array;
    }

    private static double[][] task3(short[] s, double[] x) {
        var n = new double[13][13];
        var secondList = Arrays.asList(1, 7, 11, 13, 19, 23);
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                double value;
                if (s[i] == 21) {
                    value = formula1(x[j]);
                } else if (secondList.contains((int) s[i])) {
                    value = formula2(x[j]);
                } else {
                    value = formula3(x[j]);
                }
                n[i][j] = value;
            }
        }
        return n;
    }

    private static void task4(double[][] n) {
        for (var array : n) {
            for (var item : array) {
                //System.out.printf("%.2f\t", item);
                System.out.printf("%.2f\t", item);
            }
            System.out.println();
        }
    }

    private static double getRandomDoubleFromRange(double min, double max) {
        return Math.random() * (max - min) + min;
    }

    private static double formula1(double x) {
        return log(pow(pow(Math.cos(x), 2) / 2.0, 2));
    }

    private static double formula2(double x) {
        return pow(0.75 / log(pow(abs(x) * (Math.PI + abs(x)), x)),
                pow(0.5 / (1 - cbrt(x)), 3));
    }

    private static double formula3(double x) {
        return log(Math.sqrt(pow(Math.tan(Math.sin(cbrt(x))), 2)));
    }

    private static double round(double x, int digits) {
        var mul = Math.pow(10, digits);
        return Math.round(x * mul) / mul;
    }

    private static double pow(double x, double a) {
        return Math.pow(x, a);
    }

    private static double log(double x) {
        return Math.log(x);
    }

    private static double cbrt(double x) {
        return Math.cbrt(x);
    }

    private static double abs(double x) {
        return Math.abs(x);
    }
}
