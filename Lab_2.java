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
    static int accuracy;
    static int n = 10;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введіть точність (кількість знаків після коми): ");
        accuracy = s.nextInt();
    }

    public static double sin(double x, int n){
        //function for sin(x) or sin(fi)
        x %= 2*PI;
        double answer = 0;
        for (int k = 0; k < n; k++) {
            answer += pow(-1, k) * pow(x, 2*k+1) / factorial(2*k + 1);
        }
        answer *= pow(10, accuracy);
        answer = round(answer);
        answer /= pow(10, accuracy);
        return answer;
    }

    public static double cos(double x, int n){
        //function for cos(x) or cos(fi)
        x %= 2*PI;
        double answer = 0;
        for (int k = 0; k < n; k++) {
            answer += pow(-1, k) * pow(x, 2*k) / factorial(2*k);
        }
        answer *= pow(10, accuracy);
        answer = round(answer);
        answer /= pow(10, accuracy);
        return answer;
    }

    public static long factorial(int k){
        //recursive factorial
        if(k == 1 || k == 0){
            return 1;
        }
        return k * factorial(k-1);
    }


}