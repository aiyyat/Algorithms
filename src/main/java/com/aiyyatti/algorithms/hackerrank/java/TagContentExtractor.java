package com.aiyyatti.algorithms.hackerrank.java;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        String input = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
        doTagContentExtractor(input);
    }

    @Test
    public void simple2Test() {
        String input = "<Amee>safat codes like a ninja</amee>\n";
        doTagContentExtractor(input);
    }

    @Test
    public void simple3Test() {
        String[] inputs = new String[]{"<h1>some</h1>", "<h1>had<h1>public</h1></h1>", "<h1>had<h1>public</h1515></h1>", "<h1><h1></h1></h1>", "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", "<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>", "<>hello</>", "<>hello</><h>dim</h>", "<>hello</><h>dim</h>>>>>"};
        for (String str : inputs)
            doTagContentExtractor(str);
    }

    @Test
    public void simple4Test() {
        String[] inputs = new String[]{"<h1>Nayeemlovescounseling</h1>" ,
                "<h1><h1>Sanjayhasnowatch</h1></h1><par>Sowaitforawhile<par>" ,
                "<Amee>safatcodeslikeaninja</amee>" ,
                "<SApremium>Imtiazhasasecretcrash</SApremium>"};
        for (String str : inputs)
            doTagContentExtractor(str);
    }

    public void doTagContentExtractor(String input) {

        Pattern pattern = Pattern.compile("<(.+)>([^<]+)</\\1>");
        Matcher matcher = pattern.matcher(input);
        boolean match = false;
        while (matcher.find()) {
            match = true;
            System.out.printf(">%s<\n",matcher.group(2));
        }
        if (!match) System.out.println("None");
    }
}
