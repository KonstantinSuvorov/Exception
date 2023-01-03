package src.Checker;

public class PhoneException extends Exception {
    String inputString;

    public PhoneException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Ошибка при вводе номера телефона " + inputString
                + " (формат номера телефона - 10 цифр без разделителей 0123456789)\n";
    }
}