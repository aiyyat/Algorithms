package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time: 45.39
 * Todo:
 * Redo: No
 * Notes:
 */
public class BabyNames {
    private static final Logger logger = getLogger(BabyNames.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void ctciTest() {
        Map<String, Integer> names = new HashMap<>();
        names.put("Jon", 10);
        names.put("John", 14);
        names.put("Johnny", 3);
        names.put("Johny", 12);
        names.put("Simple", 22);
        names.put("Simon", 20);
        names.put("Silly", 3);
        names.put("Sally", 3);
        names.put("Susie", 9);
        names.put("Daniel", 9);
        names.put("Craig", 19);
        String[][] connections = new String[][]{
                new String[]{"Jon", "John"},
                new String[]{"Johny", "Johnny"},
                new String[]{"John", "Johny"},
                new String[]{"Simple", "Simon"},
                new String[]{"Susie", "Sally"},
                new String[]{"Silly", "Sally"}};
        Map<String, Integer> john = new HashMap<>();
        john.put("John", 39);
        john.put("Johnny", 39);
        john.put("Johny", 39);
        john.put("Jon", 39);
        john.put("John", 39);
        System.out.println(doBabyNames(names, connections));
        assertThat(doBabyNames(names, connections)).containsAnyOf(
                Map.entry("Jon", 39),
                Map.entry("John", 39),
                Map.entry("Johny", 39),
                Map.entry("Johnny", 39)
        );
    }

    //////////////
    // SOLUTION //
    //////////////
    public Map<String, Integer> doBabyNames(Map<String, Integer> names, String[][] connections) {
        Map<String, Integer> output = new HashMap<>();
        Map<String, Name> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        for (Iterator<String> itr = names.keySet().iterator(); itr.hasNext(); ) {
            String name = itr.next();
            int count = names.get(name);
            map.put(name, new Name(count, name));
        }
        int N = connections.length;
        for (int i = 0; i < N; i++) {
            append(map.get(connections[i][0]), map.get(connections[i][1]));
        }
        for (Iterator<String> itr = map.keySet().iterator(); itr.hasNext(); ) {
            String name = itr.next();
            if (!visited.contains(name)) {
                Name current = map.get(name);
                int count = visit(current, visited);
                output.put(current.name, count);
            }
        }
        return output;
    }

    public int visit(Name nameObj, Set<String> visited) {
        int count = 0;
        if (!visited.contains(nameObj.name)) {
            count = nameObj.count;
            visited.add(nameObj.name);
            for (Iterator<Name> iterator = nameObj.neighbours.iterator(); iterator.hasNext(); ) {
                Name neighbour = iterator.next();
                count += visit(neighbour, visited);
            }
        }
        return count;
    }

    public void append(Name name1, Name name2) {
        logger.debug("name1{}, name2{}", name1, name2);
        name1.addNeighbour(name2);
        name2.addNeighbour(name1);
    }

    class Name {
        List<Name> neighbours = new LinkedList<>();
        int count;
        String name;

        public Name(int count, String name) {
            this.count = count;
            this.name = name;
        }

        public void addNeighbour(Name name) {
            neighbours.add(name);
        }

        @Override
        public String toString() {
            return "Name{" +
                    "count=" + count +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
