import java.util.Scanner;

import static java.lang.Math.*;

class Lab_2 {
    static int accuracy;
    static int n = 10;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введіть точність (кількість знаків після коми): ");
        accuracy = s.nextInt();
//        System.out.println(sin(PI/2, n));
//        System.out.println(sin(0, n));
//        System.out.println(cos(PI/2, n));
//        System.out.println(cos(0, n));
//        System.out.println(sin(PI/6, n));
//        System.out.println(cos(PI/6, n));
//        System.out.println(Math.cos(PI/6));

        System.out.println(sin(PI/2 + PI, n));
        System.out.println(sin(2*PI, n));
        System.out.println(sin(3*PI + PI/2, n));
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