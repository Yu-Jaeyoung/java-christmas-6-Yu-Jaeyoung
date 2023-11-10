package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import christmas.constant.Phrase;

public class InputView {
    public static String readDate() {
        System.out.println(Phrase.ASK_DATE);
        return Console.readLine();
    }
}
