package christmas.util;

import java.text.DecimalFormat;

public class Formatter {
    public static String decimalFormatter(final int cost) {
        final DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(cost);
    }
}
