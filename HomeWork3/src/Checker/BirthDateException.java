package src.Checker;

public class BirthDateException extends Exception {

    String inputString;

    public BirthDateException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Ошибка формата при вводе даты '" + inputString + "', формат ввода 'дд.мм.гггг'.\n";
    }
}
