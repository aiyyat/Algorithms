package com.aiyyatti.algorithms.ctci.moderate;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * This is a vague idea only.
 */
public class EnglishInt {
    @Test
    public void simpleTest0() {
        TestCase.assertEquals("one thousand two hundred eleven", doEnglishInt(1211));
    }

    @Test
    public void simpleTest7() {
        TestCase.assertEquals("one thousand ten", doEnglishInt(1010));
    }

    @Test
    public void simpleTest4() {
        TestCase.assertEquals("eleven", doEnglishInt(11).trim());
    }

    @Test
    public void simpleTest5() {
        TestCase.assertEquals("twenty", doEnglishInt(20).trim());
    }

    @Test
    public void simpleTest6() {
        TestCase.assertEquals("zero", doEnglishInt(0).trim());
    }

    @Test
    public void simpleTest1() {
        TestCase.assertEquals("one thousand two hundred thirty four", doEnglishInt(1234));
    }

    @Test
    public void simpleTest2() {
        TestCase.assertEquals("one thousand thirty four", doEnglishInt(1034));
    }

    public String doEnglishInt(int i) {
        Unit unit = new Unit();
        return unit.convert(i);
    }

    abstract class Place {
        String name[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        Place() {
        }

        public abstract Place delegate();

        public String name(int i) {
            return name[i];
        }

        public abstract String read(int i, String str);

        public String convert(int i) {
            return convert(i, "");
        }

        public String convert(int i, String str) {
            String value = delegate() != null ? delegate().convert(i, read(i, str)) : read(i, str);
            return value.replaceAll("  ", " ");
        }
    }

    class Unit extends Place {
        @Override
        public Place delegate() {
            return new Tens();
        }

        @Override
        public String read(int i, String str) {
            return name(i % 10);
        }
    }

    class Tens extends Place {
        String lessThanTwenty[] = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String greaterThanNinteen[] = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninty"};

        @Override
        public Place delegate() {
            return new Hundreds();
        }

        @Override
        public String read(int i, String str) {
            int myDigit = (i / 10) % 10;
            int value = i % 100;
            if (value < 10) return str;
            if (value >= 10 && value < 20) return lessThanTwenty[value - 10];
            else return greaterThanNinteen[myDigit - 2] + " " + (value % 10 == 0 ? "" : str);
        }
    }

    class Hundreds extends Place {

        @Override
        public String read(int i, String str) {
            int myDigit = (i / 100) % 10;
            String name = myDigit > 0 ? name(myDigit) + " hundred " : " ";
            return name + str;
        }

        @Override
        public Place delegate() {
            return new Thousand();
        }
    }

    class Thousand extends Place {

        @Override
        public String read(int i, String str) {
            int myDigit = (i / 1000) % 10;
            String name = myDigit > 0 ? name(myDigit) + " thousand " : " ";
            return name + str;
        }

        @Override
        public Place delegate() {
            return null;
        }
    }

}
