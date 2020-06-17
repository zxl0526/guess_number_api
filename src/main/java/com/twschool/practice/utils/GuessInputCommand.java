package com.twschool.practice.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessInputCommand {


    public static boolean judgeInputFormat(String input) {
        input = input.replace(" ", "");
        if(input.length() != 4) {
            return false;
        }

        StringBuffer sb = new StringBuffer(input);
        String rs = sb.reverse().toString().replaceAll("(.)(?=.*\\1)", "");
        StringBuffer out = new StringBuffer(rs);
        String result = out.reverse().toString();
        if(result.length() != 4) {
            return false;
        }

        return true;
    }
}
