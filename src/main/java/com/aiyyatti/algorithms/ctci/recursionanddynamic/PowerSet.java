package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import junit.framework.TestCase;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PowerSet {
    @Test
    public void testSimple() {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(0);
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        input.add(6);
        input.add(7);
        input.add(8);
        input.add(9);
        TestCase.assertEquals(((int) Math.pow(2, input.size())), doPowerSet(input).size());
    }

    public LinkedList<LinkedList<Integer>> doPowerSet(ArrayList<Integer> input) {
        return doPowerSet(input, 0);
    }

    public LinkedList<LinkedList<Integer>> doPowerSet(ArrayList<Integer> input, int index) {
        LinkedList<LinkedList<Integer>> powerSet = new LinkedList<>();
        if (input.size() == index) powerSet.add(new LinkedList<>());
        else {
            powerSet = doPowerSet(input, index + 1);
            LinkedList<LinkedList<Integer>> powerSetTemp = new LinkedList<>();
            for (LinkedList<Integer> output : powerSet) {
                LinkedList<Integer> outputTemp = new LinkedList<>();
                outputTemp.addAll(output);
                outputTemp.add(input.get(index));
                powerSetTemp.add(outputTemp);
            }
            powerSet.addAll(powerSetTemp);
        }
        return powerSet;
    }
}
