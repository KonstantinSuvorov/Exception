// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
// и возвращающий новый массив, каждый элемент которого равен разности 
// элементов двух входящих массивов в той же ячейке.
// Если длины массивов не равны, необходимо как-то оповестить пользователя.

package HomeWork1;

import java.util.Random;

public class Task_2 {
    public static void main(String[] args) {
        // Формирование первого массива (firstArray)
        int[] firstArray = getFilledArray(10);
        // Формирование второго массива (secondArray)
        int[] secondArray = getFilledArray(9);
        // Проверка правильности ввода массивов и результат
        int[] divArray = divArrays(firstArray, secondArray); 
    }

    // Метод проверки правильности ввода массиовов и результат
    public static int[] divArrays(int[] firstArray, int[] secondArray) {
        
        // Если массивы разных размеров
        if(firstArray.length != secondArray.length) 
            throw new RuntimeException("Массивы имеют разные размеры!");
        
            int[] resultArr = new int[firstArray.length];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = firstArray[i] - secondArray[i];
        }
        return resultArr;
    }
    // Метод формирования массива
    public static int[] getFilledArray(int length){
        int[] array = new int[length];
        Random rnd = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = rnd.nextInt(20);
        }
        return array;
    }
}
