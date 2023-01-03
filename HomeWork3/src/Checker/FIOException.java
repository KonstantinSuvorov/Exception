package src.Checker;

public class FIOException extends Exception {

    String inputString;

    public FIOException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Ошибка при вводе ФИО '" + inputString + "'. Данные должны включать только буквы.\n";
    }
}