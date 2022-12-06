// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

// Примечание:
// 1. Деление на ноль
// 2. Выход за границы массива
// 3. Отсутствие указателя NULL

package HomeWork1;

public class Task_1 {
    public static void main(String[] args) {
        String[] sArray = {"first str", null, "third str"};
        final int[] array = {12, 10, 8, 6, 4, 2, 1, 2, 3, 0};
        division(12, 1);
        printValueByIndex(array,9);
        printStringArray(sArray);

    }
    
    // 1. Деление на ноль (DBZ - Division by zero)
    public static void division(double firstNum, double secondNum){
        if(secondNum ==  0) throw new ArithmeticException("На ноль делить нельзя!!!");
        double result = firstNum/secondNum;
        System.out.printf("Результат деления %f на %f равен %f.\n", firstNum, secondNum, result);
    }
    
    // 2. Выход  индекса за границы массива (OOB - Out of bounds)
    public static void printValueByIndex(int[] array, int index){
        if(index > array.length-1) throw new ArrayIndexOutOfBoundsException("Элемента под таким индексом не существует");
        else System.out.printf("Элемент с индексом %d равен %d.\n",index, array[index]);
    }

    // 3. Попытка обратиться к ссылке Null (NPE - Null pointer exception)
    public static void printStringArray(String[] sArray){
        for (String item: sArray){
            if(item == null) throw new NullPointerException("Элемент отсутствует!");
            System.out.println(item);
        }
    }
}