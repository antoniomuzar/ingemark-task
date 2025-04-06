package com.example.ingemark_task.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {
    public static double roundToTwoDecimalPlaces(double value) {
        return new BigDecimal(value)
          .setScale(2, RoundingMode.HALF_UP)
          .doubleValue();
    }
}

