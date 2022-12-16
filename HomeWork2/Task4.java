// Разработайте программу, которая выбросит Exception, 
// когда пользователь вводит пустую строку. 
// Пользователю должно показаться сообщение, 
// что пустые строки вводить нельзя.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите любой текст кроме пустой строки");
        try {
            String result = reader.readLine();
            if(result.equals("")) 
               throw new RuntimeException("Пустую строку вводить нельзя");
               System.out.println("Введена строка: ");
               System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}