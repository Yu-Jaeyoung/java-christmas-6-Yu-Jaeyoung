package christmas;

import christmas.constant.Phrase;
import christmas.view.Input;

public class Application {
    public static void main(String[] args) {
        System.out.println(Phrase.WELCOME);
        Input.readDate();
    }
}
