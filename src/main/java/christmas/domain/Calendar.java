package christmas.domain;

import java.util.Arrays;
import java.util.List;

public final class Calendar {
    static final String EVENT_PREVIEW = "우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private final int date;
    private final List<Integer> weekend = Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
    private final List<Integer> starDay = Arrays.asList(3, 10, 17, 24, 25, 31);

    public Calendar(final int date) {
        this.date = date;
    }

    public boolean isWeekend() {
        return weekend.contains(this.date);
    }

    public boolean isStarDay() {
        return starDay.contains(this.date);
    }

    public int christmasDDay() {
        if (this.date < 26) {
            return date;
        }
        return 0;
    }

    public void eventPreview() {
        System.out.printf("12월 %d일에 %s\n\n", this.date, EVENT_PREVIEW);
    }
}
