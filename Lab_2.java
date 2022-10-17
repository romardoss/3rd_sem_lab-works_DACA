//Берегун Роман, група ТР-11
//Berehun Roman, TR-11 group

//Створити методи, що обчислюють функції синуса та косинуса, обраховуючи ряд.
//Функцію факторіалу зробити рекурсивною
//Вивести на екран таблицю значень даної функції (Равлик Паскаля) за конкретних кутів

//Create methods to calculate sin and cos functions using series
//Factorial function make using recursion
//Print table of results of Limaçon function with different angles

import java.util.Scanner;

import static java.lang.Math.*;

class Lab_2 {
    static int accuracy = 5;
    static int n;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введіть точність (кількість ітерацій для розрахунку синуса та косинуса): ");
        n = s.nextInt();
        int a = 1;
        int b = 2;
        // b >= 2a
        System.out.println("Результат, використовуючи обраховані з ряду значення синуса та косинуса");
        limacon(a, b, 0, 2*PI);
        System.out.println();
        System.out.println("Результат, використовуючи стандартні значення синуса та косинуса");
        limacon_standard(a, b, 0, 2*PI);
    }

    public static double sin(double x, int n){
        //function for sin(x) or sin(fi)
        x %= 2*PI;
        double answer = 0;
        for (int k = 0; k < n; k++) {
            answer += pow(-1, k) * pow(x, 2*k+1) / factorial(2*k + 1);
        }
//        answer *= pow(10, accuracy);
//        answer = round(answer);
//        answer /= pow(10, accuracy);
        return answer;
    }

    public static double cos(double x, int n){
        //function for cos(x) or cos(fi)
        x %= 2*PI;
        double answer = 0;
        for (int k = 0; k < n; k++) {
            answer += pow(-1, k) * pow(x, 2*k) / factorial(2*k);
        }
//        answer *= pow(10, accuracy);
//        answer = round(answer);
//        answer /= pow(10, accuracy);
        return answer;
    }

    public static long factorial(int k){
        //recursive factorial
        if(k == 1 || k == 0){
            return 1;
        }
        return k * factorial(k-1);
    }

    public static void limacon(int a, int b, double start, double end){
        //limaçon using our own sin() and cos() functions
        System.out.println("|Кут\t|x\t\t\t|y\t\t\t|ρ\t\t\t|");
        for (double i = start; i < end; i += 0.1) {
            double c = cos(i, n);
            double s = sin(i, n);
            double x = a*c*c + b*c;
            double y = a*s*c + b*c;
            double p = 2*a*c + b;
            System.out.printf("|%.2f\t|%f\t|%f\t|%f\t|\n", i, x, y, p);
        }
    }

    public static void limacon_standard(int a, int b, double start, double end){
        //limaçon using our standard sin() and cos() functions
        System.out.println("|Кут\t|x\t\t\t|y\t\t\t|ρ\t\t\t|");
        for (double i = start; i < end; i += 0.1) {
            double c = Math.cos(i);
            double s = Math.sin(i);
            double x = a*c*c + b*c;
            double y = a*s*c + b*c;
            double p = 2*a*c + b;
            System.out.printf("|%.2f\t|%f\t|%f\t|%f\t|\n", i, x, y, p);
        }
    }
}