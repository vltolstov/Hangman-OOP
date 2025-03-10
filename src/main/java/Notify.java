public class Notify {

    public void getMessage(String message) {
        System.out.println(message);
    }

    public void gerError(Integer errorCount) {
        System.out.println("Такой буквы в слове нет." + " " + "Осталось попыток: " + errorCount);
    }

    public void getCongratulations() {
        System.out.println("Победа!");
    }

    public void getCondolences(String secretWord) {
        System.out.println("Вы проиграли. Попробуйте еще раз. Загаданное слово: " + secretWord);
    }
}
