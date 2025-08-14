package com.vn.bidu.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class NumberFormatUtils {
    public static String formatVNCurrency(double amount) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');

        DecimalFormat formatter = new DecimalFormat("#,###₫", symbols);
        return formatter.format(amount);
    }

    public static String formatPercentage(double value) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return formatter.format(value) + "%";
    }
}
