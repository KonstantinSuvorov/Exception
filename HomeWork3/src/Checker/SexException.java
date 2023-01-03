package src.Checker;

public class SexException extends Exception {
    String inputString;

    public SexException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Ошибка при вводе пола (допускаются только латинские буквы f или m), а не '" + inputString + "'\n";
    }
}