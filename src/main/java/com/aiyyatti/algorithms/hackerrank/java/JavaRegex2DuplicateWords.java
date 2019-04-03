package com.aiyyatti.algorithms.hackerrank.java;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegex2DuplicateWords {
    @Test
    public void simpleTest() {
        String str = "Sam went went went to to to his business";
        System.out.println(doJavaRegex2DuplicateWords(str));
    }

    public String doJavaRegex2DuplicateWords(String str) {
        String regex = "\\b(\\w+)(\\s+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);
        while (m.find()) {
            str = str.replace(m.group(), m.group(1));
        }
        return str;
    }
}
