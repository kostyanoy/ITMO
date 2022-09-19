//Лабораторная 1 Манухин Константин Вариант 44214
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
        return array;
    }

    private static double[] task2() {
        var array = new double[13];
        for (int i = 0; i < 13; i++) {
            array[i] = getRandomDoubleFromRange(-5.0, 6.0);
        }
        return array;
    }

    private static double[][] task3(short[] s, double[] x) {
        var array = new double[13][13];
        var condition = new int[]{1, 7, 11, 13, 19, 23};
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                double value;
                if (s[i] == 21) {
                    value = formula1(x[j]);
                } else if (contains(condition, s[i])) {
                    value = formula2(x[j]);
                } else {
                    value = formula3(x[j]);
                }
                array[i][j] = value;
            }
        }
        return array;
    }

    private static void task4(double[][] n) {
        for (var array : n) {
            for (var item : array) {
                System.out.printf("%.2f\t", item);
            }
            System.out.println();
        }
    }

    private static double getRandomDoubleFromRange(double min, double max) {
        return Math.random() * (max - min) + min;
    }

    private static boolean contains(int[] array, int value) {
        for (var item : array) {
            if (item == value) {
                return true;
            }
        }
        return false;
    }

    private static double formula1(double x) {
        return Math.log(Math.pow(Math.pow(Math.cos(x), 2) / 2, 2));
//        x = Math.cos(x);
//        x = Math.pow(x, 2) / 2;
//        x = Math.pow(x, 2);
//        x = Math.log(x);
//        return x;
    }

    private static double formula2(double x) {
        return Math.pow(0.75 / Math.log(Math.pow((Math.abs(x) + Math.PI) * Math.abs(x), x)), Math.pow(0.5 / (1 - Math.cbrt(x)), 3));
//        double res = Math.abs(x) + Math.PI;
//        res = res * Math.abs(x);
//        res = Math.pow(res, x);
//        res = Math.log(res);
//        res = 0.75 / res;
//        double p = 1 - Math.cbrt(x);
//        p = 0.5 / p;
//        p = Math.pow(p, 3);
//        res = Math.pow(res, p);
//        return res;
    }

    private static double formula3(double x) {
        return Math.log(Math.sqrt(Math.pow(Math.tan(Math.sin(Math.cbrt(x))), 2)));
//        x = Math.cbrt(x);
//        x = Math.sin(x);
//        x = Math.tan(x);
//        x = Math.pow(x, 2);
//        x = Math.sqrt(x);
//        x = Math.log(x);
//        return x;
    }
}
