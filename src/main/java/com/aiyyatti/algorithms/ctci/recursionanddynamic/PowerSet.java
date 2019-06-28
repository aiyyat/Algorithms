package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import junit.framework.TestCase;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PowerSet {
    ////////////////
    // TEST CASES //
    ////////////////
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
        assertEquals(((int) Math.pow(2, input.size())), doPowerSet(input).size());
    }

    public LinkedList<LinkedList<Integer>> doPowerSet(ArrayList<Integer> input) {
        LinkedList<LinkedList<Integer>> output = new LinkedList<>();
        output.add(new LinkedList<Integer>());
        for (int i = 0; i < input.size(); i++) {
            LinkedList<LinkedList<Integer>> temp = copyOf(output);
            for (Iterator<LinkedList<Integer>> itr = temp.iterator(); itr.hasNext(); )
                itr.next().add(input.get(i));
            output.addAll(temp);
        }
        System.out.print(output.toString());
        return output;
    }

    public LinkedList<LinkedList<Integer>> copyOf(LinkedList<LinkedList<Integer>> input) {
        LinkedList<LinkedList<Integer>> output = new LinkedList<>();
        for (Iterator<LinkedList<Integer>> itr = input.iterator(); itr.hasNext(); ) {
            output.add((LinkedList<Integer>) itr.next().clone());
        }
        return output;
    }
}