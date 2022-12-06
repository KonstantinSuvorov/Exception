// Реализуйте метод, принимающий в качестве аргументов 
// два целочисленных массива, и возвращающий новый массив,
// каждый элемент которого равен частному элементов двух 
// входящих массивов в той же ячейке.
// Если длины массивов не равны, необходимо как-то оповестить пользователя.

// Важно: При выполнении метода единственное исключение, 
// которое пользователь может увидеть - RuntimeException, т.е. ваше.

package HomeWork1;

import java.util.Arrays;

public class task_3 {
    public static void main(String[] args) {
        int[] array1 = {5, 2, 3, 4, 6};
        int[] array2 = {1, 1, 0, 2, 3};
        System.out.println(Arrays.toString(method(array1, array2)));
    }
    // Метод возвращающий новый массив,
    // каждый элемент которого равен частному 
    // от деления элементов двух 
    // входящих массивов в той же ячейке.
    public static int[] method(int[] arr1, int[] arr2) {
        
        // Если массивы имеют разную длину
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Массивы имеют различный размер");
        }
        int[] array = new int[arr1.length];
        
        for (int i = 0; i < arr1.length; i++) {
            // Если второй массив содержит 0
            if (arr2[i] == 0) {
                throw new RuntimeException("На ноль делить нельзя!");
            }
            array[i] = arr1[i] / arr2[i];
        }
        return array;
    }
}