package com.bridgelabz.HashTables;

import java.util.*;

import java.util.LinkedList;

public class WordFrequency {

    public static void main(String[] args) {

        // The paragraph to analyze
        String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";

        // Convert the paragraph to lowercase and split it into words
        String[] words = paragraph.toLowerCase().split(" ");

        // Create an array of LinkedLists to store the words and their frequencies
        LinkedList<MyMapNode>[] wordList = new LinkedList[words.length];

        // Initialize the LinkedLists
        for (int i = 0; i < words.length; i++) {
            wordList[i] = new LinkedList<>();
        }

        // Loop through the words and store their frequencies
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int index = Math.abs(word.hashCode() % words.length);

            // Search for the word in the LinkedList at the corresponding index
            MyMapNode node = null;
            LinkedList<MyMapNode> list = wordList[index];
            for (MyMapNode n : list) {
                if (n.getKey().equals(word)) {
                    node = n;
                    break;
                }
            }

            // If the word is not found, add it to the LinkedList with frequency 1
            if (node == null) {
                node = new MyMapNode(word, 1);
                list.add(node);
            }
            // If the word is found, increment its frequency
            else {
                node.setValue(node.getValue() + 1);
            }
        }

        // Print the frequencies of the words
        for (int i = 0; i < words.length; i++) {
            LinkedList<MyMapNode> list = wordList[i];
            for (MyMapNode node : list) {
                System.out.println(node.getKey() + " : " + node.getValue());
            }
        }
    }
}