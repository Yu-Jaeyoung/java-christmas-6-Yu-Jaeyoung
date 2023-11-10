package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import christmas.constant.Phrase;

public class Input {
    public static void readDate() {
        System.out.println(Phrase.ASK_DATE);
        String input = Console.readLine();
    }
}
