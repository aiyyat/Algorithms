package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time:
 * Todo:
 * Redo: Yes
 * Notes: Trie is simple, but below is a way to make it appear intimidating.
 */
public class MultiSearch {
    private static final Logger logger = getLogger(MultiSearch.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void simpleTest() {
        String whole = "mississippi";
        String[] words = new String[]{"m", "miss", "mis", "is", "sip", "pi", "tsi"};
        doMultiSearch(whole, words);
    }

    public void doMultiSearch(String whole, String[] words) {
        Trie root = new Trie('*');
        int N = words.length;
        for (int i = 0; i < N; i++) {
            Trie parent = root;
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                parent = parent.append(word.charAt(j));
            }
            parent.terminates();
        }
        N = whole.length();
        upper:
        for (int i = 0; i < N; i++) {
            Trie parent = root;
            String word = "";
            for (int j = i; j < N; j++) {
                char key = whole.charAt(j);
                word += key;
                Trie child = parent.tries.get(key);
                if (child == null) {
                    continue upper;
                } else if (child.willTerminate()) {
                    System.out.printf("\n found %s", whole.substring(i, j + 1));
                }
                parent = child;
            }
            System.out.println();
        }
    }
    //////////////
    // SOLUTION //
    //////////////

    class Trie {
        Character character;
        Map<Character, Trie> tries = new HashMap<>();
        boolean terminates;

        public Trie(Character character) {
            this.character = character;
        }

        public Trie append(Character ch) {
            Trie trie = tries.getOrDefault(ch, new Trie(ch));
            tries.put(ch, trie);
            return trie;
        }

        public void terminates() {
            terminates = true;
        }

        public boolean willTerminate() {
            return terminates;
        }

        @Override
        public String toString() {
            return character.toString();
        }
    }
}