package pages;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tester {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()));
    }
}
