package com.company;
import java.util.Scanner;

public class Main {

    /* Сортировка пузырьком
    param[in] - одномерный массив
    */
    public static void _sort(int mass[]) {
        boolean start = true; // флаг чтобы начать цикл while
        boolean end_sort = false; // флаг, который сигнализируют об окончании сортировки
        int temp;
        while (start) {
            for (int i = 0; i < mass.length-1; i++) {
                if (mass[i + 1] < mass[i]) {
                    temp = mass[i];
                    mass[i] = mass[i + 1];
                    mass[i + 1] = temp;
                    end_sort = false;
                }
            }
            if (end_sort == true) { // Если за весь проход в цикле не было ни одного обмена, то сортировка окончена
                start = false;
            }
            end_sort = true;
        }
    }
    /* Бинарный поиск
    param[in] - отсортированный массив, искомое чило
    param[out] - индекс искомого числа
    */
    public static int search (int sort_mass[], int search_number){
        int index; // Искомый индекс
        int left_border = 0; // левая граница
        int right_border = sort_mass.length-1; // правая граница
        int center;
       while (left_border < right_border) {
           center = (int)(Math.floor((left_border+right_border) / 2)); // Math.floor - округляет вниз
           if (sort_mass[center] < search_number) {
               left_border = center+1; // сдвигаем левую границу
           } else if (sort_mass[center] > search_number) {
               right_border = center-1; // сдвигаем правую границу
           } else if (sort_mass[center] == search_number) {
               return center;
           }
       }
       if (sort_mass[left_border] == search_number){ // если искомое чило на одной из границ
           return left_border;
       }
       else
           return -1; // Искомое число не найдено
    }

        public static void main(String[] args) {
            int N = 12;
            int [] mass = new int[N];
            System.out.println("--- Первоначальный массив ---");
            /*
            Заполнение массива рандомными числами.
            Для удобства проверки делаю рандом в определенном диапозоне, чтобы заполняемые
            рандомом числа были небольшие. Поэтому использую Math.random() - заполняет в  диапазоне [0,1).
             */
            for (int i = 0; i< mass.length; i++) {
                mass[i]= ((int)(Math.random()*201 - 100)); // диапозон [-100;100]
                System.out.print(mass[i]+" ");
            }
            _sort(mass); // Сортировка пузырьком
            System.out.println("\n"+"--- Отсортированный массив ---");
            for (int i = 0; i< mass.length; i++){
                System.out.print(mass[i]+" ");
            }
            Scanner in = new Scanner(System.in);
            System.out.print("\nВведите искомое число ");
            int M = in.nextInt();
            // Бинарный поиск
            int find = search(mass,M);
            if (M == -1){
                System.out.println("Искомого числа нет");
            }
            else {
                System.out.println("Искомое число под индексом " + find);
            }

        }
}