package ru.kolesnikov.bank.dao.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }
}
