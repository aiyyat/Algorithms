package com.aiyyatti.algorithms.hackerrank.allcontests.amazon;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * https://www.hackerrank.com/contests/amazon/challenges/shortest-sub-segment
 */
public class ShortestSubSegment {
    @Test
    public void hackerRankTest() {
        String input = "This is a test. This is a programming test. This is a programming test in any language.";
        String[] toFind = new String[]{"this", "a", "test", "programming"};
        assertThat(doShortestSubSegment(input, toFind), is(equalTo("a programming test This")));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int count = scanner.nextInt();
        String[] a = new String[count];
        for (int i = 0; i < count; i++) {
            a[i] = scanner.next().toLowerCase();
        }
        System.out.println(doShortestSubSegment(input, a));
    }

    public static String doShortestSubSegment(String input, String[] a) {
        Map<String, PriorityQueue<Integer>> table = new HashMap<>();
        String[] words = input.split("[\\p{Punct}\\s]+");
        for (int i = 0; i < a.length; i++) {
            table.put(a[i], new PriorityQueue<>());
        }
        for (int i = 0; i < words.length; i++) {
            PriorityQueue<Integer> tableData = table.getOrDefault(words[i].toLowerCase(), null);
            if (null != tableData) tableData.add(i);
        }
        for (int i = 0; i < a.length; i++) {
            if (table.get(a[i]).isEmpty()) return "NO SUBSEGMENT FOUND";
        }

        PriorityQueue<Entry> entries = new PriorityQueue<>((o1, o2) -> {
            return o1.getPosition().compareTo(o2.getPosition());
        });
        Entry minEntry = new Entry(Integer.MAX_VALUE, null), maxEntry = new Entry(Integer.MIN_VALUE, null);
        for (int i = 0; i < a.length; i++) {
            PriorityQueue<Integer> aPQ = table.get(a[i]);
            Integer position = aPQ.poll();
            Entry entry = new Entry(position, aPQ);
            entries.add(entry);
            if (entry.compareTo(maxEntry) > 0) maxEntry = entry;
            if (entry.compareTo(minEntry) < 0) minEntry = entry;
        }
        Integer best = maxEntry.getPosition() - minEntry.getPosition();
        Entry from = minEntry, to = maxEntry;
        while (true) {
            minEntry = entries.poll();
            Integer local = maxEntry.getPosition() - minEntry.getPosition();
            if (local < best) {
                best = local;
                from = minEntry;
                to = maxEntry;
            }
            PriorityQueue<Integer> queue = minEntry.getQueue();
            Integer newPosition = queue.poll();
            Entry newEntry = new Entry(newPosition, queue);
            if (newPosition == null) break;
            if (newPosition > maxEntry.getPosition()) maxEntry = newEntry;
            entries.add(newEntry);
        }
        String output = "";
        for (int i = from.getPosition(); i <= to.getPosition(); i++) output += words[i] + " ";
        return output.trim();
    }

}

class Entry implements Comparable<Entry> {
    private Integer position;
    private PriorityQueue<Integer> queue;

    @Override
    public int compareTo(Entry o) {
        return this.position.compareTo(o.position);
    }

    public Entry(Integer position, PriorityQueue<Integer> queue) {
        this.position = position;
        this.queue = queue;
    }

    public Integer getPosition() {
        return position;
    }

    public PriorityQueue<Integer> getQueue() {
        return queue;
    }
}