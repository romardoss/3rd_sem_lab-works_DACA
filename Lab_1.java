//Берегун Роман, група ТР-11

//Задана матриця M*N. Відсортувати непарні рядки за зростанням
//Необхідно написати програмний код, у
//якому реалізується сортування масивів методами бульбашки, вставок, вибору,
//сортуванням Шелла, Гоара (швидкого сортування). Виконати порівняння
//ефективності вказаних методів сортування

//Matrix M*N is given. Sort it with bubble, insertion, selection, Shell`s
// and Hoare (quick sort) sorting algorithms

import java.util.Scanner;

class Lab_1 {
    public static final String setYellow = "\u001B[33m";
    public static final String setBlue = "\u001B[34m";
    public static final String setDefault = "\u001B[0m";

    public static long start, end;
    public static int iterations = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter M and N: ");
        int m = s.nextInt();
        int n = s.nextInt();
        int[][] matrix = new int[m][n];

        callSort(matrix, "bubble", 1);
        callSort(matrix, "insertion", 2);
        callSort(matrix, "selection", 3);
        callSort(matrix, "Shell`s", 4);
        callSort(matrix, "Hoare`s", 5);
    }

    public static void callSort(int[][] matrix, String algoName, int algorithm){
        //this method created to make code in main method shorter
        generateMatrix(matrix);
        System.out.println("Matrix before " + algoName + " sort:");
        printMatrix(matrix, "blue");
        System.out.println();
        iterations = 0;
        start = System.nanoTime();
        switch (algorithm) {
            case 1 -> bubbleSort(matrix);
            case 2 -> insertionSort(matrix);
            case 3 -> selectionSort(matrix);
            case 4 -> shellSort(matrix);
            case 5 -> hoareForAll(matrix);
        }
        end = System.nanoTime();
        System.out.println("Matrix after " + algoName + " sort: ");
        printMatrix(matrix, "yellow");
        System.out.println("The time of executing: " + (end-start) + " ns");
        System.out.println("Number of iterations: " + iterations);
        System.out.println("\n");
    }

    public static void generateMatrix(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = (int) (Math.random() * 100);
            }
        }
    }

    public static void printMatrix(int[][] mat, String color){
        String paint = null;
        if(color.equals("yellow")){
            paint = setYellow;
        }
        else if (color.equals("blue")){
            paint = setBlue;
        }

        int m = mat.length;
        int n = mat[0].length;
        for(int i=0; i<m; i++){
            if(i%2 == 0){
                System.out.print(paint);
            }
            System.out.print("|");
            for(int j=0; j<n; j++){
                System.out.printf("%3d ", mat[i][j]);
            }
            System.out.println("|");
            System.out.print(setDefault);
        }
    }

    public static void bubbleSort(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i+=2){
            for(int j = 0; j < m-1; j++){
                for(int k = 0; k < m-1; k++) {
                    if (mat[i][k] > mat[i][k+1]) {
                        int buf = mat[i][k];
                        mat[i][k] = mat[i][k+1];
                        mat[i][k+1] = buf;
                        iterations++;
                    }
                }
            }
        }
    }

    public static void insertionSort(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i+=2){
            for(int j=1; j<m; j++){
                for(int k=j; k>0; k--){
                    if(mat[i][k] < mat[i][k-1]){
                        int buf = mat[i][k];
                        mat[i][k] = mat[i][k-1];
                        mat[i][k-1] = buf;
                        iterations++;
                    }
                    else{
                        break;
                    }
                }
            }
        }
    }

    public static void selectionSort(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int min = Integer.MAX_VALUE;
        int indexMin = -1;
        for (int i = 0; i < n; i+=2){
            for(int j=0; j<m-1; j++){
                for(int k=j; k<m; k++){
                    if (mat[i][k] < min){
                        min = mat[i][k];
                        indexMin = k;
                    }
                }
                int buf = mat[i][j];
                mat[i][j] = min;
                mat[i][indexMin] = buf;
                iterations++;
                min = Integer.MAX_VALUE;
            }
        }
    }

    public static void shellSort(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i+=2){
            for(int g=m/2 + 1; g>=1; g/=1.5){
                for(int j=0; j<m-g; j++){
                    if(mat[i][j] > mat[i][j+g]){
                        int buf = mat[i][j];
                        mat[i][j] = mat[i][j+g];
                        mat[i][j+g] = buf;
                        iterations++;
                    }
                }
            }
        }
    }

    public static void hoareSort(int[] arr, int start, int end){
        if(start>=end) return;
        int mid = arr[(end+start)/2];
        int i=start;
        int j=end;
        while(i<=j){
            if(arr[i] < mid) i++;
            if(arr[j] > mid) j--;
            else{
                int buf = arr[i];
                arr[i] = arr[j];
                arr[j] = buf;
                iterations++;
                i++;
                j--;
            }
        }
        i--;
        hoareSort(arr, start, i);
        hoareSort(arr, i+1, end);
    }

    public static void hoareForAll(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i+=2){
            hoareSort(mat[i], 0, m-1);
        }
    }

}