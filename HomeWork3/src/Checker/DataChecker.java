package src.Checker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

// Проверка полноты и правильности введенных данных.
// Вывод предупреждений об ошибках ввода

public class DataChecker {
    public static int dataCount = 6; // Количество полей ввода данных
    private String firstName; // Имя
    private String lastName; // Фамилия
    private String patronymic; // Отчество
    private LocalDate birthDate; // Дата рождения
    private Long phoneNumber; // Номер телефона
    private Sex sex; // Пол

    // Проверка вводимых данных
    public DataChecker() {
    }

    public void CheckData(String[] splitedString) throws ParsingDataStringException {
        if (splitedString == null) {
            throw new NullPointerException("Нет данных");
        }

        StringBuilder fullErrorsMessages = new StringBuilder();
        for (String string : splitedString) {
            if (Character.isLetter(string.charAt(0))) {
                if (string.length() == 1) {
                    if (this.sex == null) {
                        try {
                            this.sex = checkSex(string);
                        } catch (SexException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Пол введен больше 1 раза\n");
                    }
                } else {
                    if (this.lastName == null) {
                        try {
                            this.lastName = checkFIO(string);
                        } catch (FIOException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else if (this.firstName == null) {
                        try {
                            this.firstName = checkFIO(string);
                        } catch (FIOException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else if (this.patronymic == null) {
                        try {
                            this.patronymic = checkFIO(string);
                        } catch (FIOException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Введено больше 3 элементов ФИО\n");
                    }
                }
            } else {

                if (string.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
                    if (this.birthDate == null) {
                        try {
                            this.birthDate = checkBirthDate(string);
                        } catch (BirthDateException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Введено больше 1 даты рождения: '"
                                + this.birthDate + "','" + string + "'\n");
                    }
                } else {
                    if (this.phoneNumber == null) {
                        try {
                            this.phoneNumber = checkPhoneNumber(string);
                        } catch (PhoneException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Введено больше 1 телефонного номера: '"
                                + this.phoneNumber + "','" + string + "'\n");
                    }
                }

            }
        }
        if (!fullErrorsMessages.isEmpty()) {
            throw new ParsingDataStringException(fullErrorsMessages.toString());
        }
    }

    public String getLastName() {
        return lastName;
    }

    private String checkFIO(String inputString) throws FIOException {
        if (inputString.toLowerCase(Locale.ROOT).matches("^[а-яёa-z]*$")) {    
            return inputString;
        } else {
            throw new FIOException(inputString);
        }
    }

    private LocalDate checkBirthDate(String inputString) throws BirthDateException {
        try {
            return LocalDate.parse(inputString,
                    DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new BirthDateException(inputString);
        }
    }

    private long checkPhoneNumber(String inputString) throws PhoneException {
        if (inputString.length() == 10) {
            try {
                return Long.parseLong(inputString);
            } catch (NumberFormatException e) {
                throw new PhoneException(inputString);
            }
        } else {
            throw new PhoneException(inputString);
        }
    }

    private Sex checkSex(String inputString) throws SexException {
        try {
            return Sex.valueOf(inputString);
        } catch (IllegalArgumentException e) {
            throw new SexException(inputString);
        }
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(lastName).append(">")
                .append("<").append(firstName).append(">")
                .append("<").append(patronymic).append(">")
                .append("<").append(birthDate.toString()).append(">")
                .append("<").append(phoneNumber).append(">")
                .append("<").append(sex).append(">");
        return sb.toString();
    }

}