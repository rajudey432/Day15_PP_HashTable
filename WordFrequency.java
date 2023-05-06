package com.bridgelabz.HashTables;

import java.util.*;

public class WordFrequency {

    // MyMapNode to store key-value pair for each word
    static class MyMapNode {
        String key;
        Integer value;
        MyMapNode next;

        public MyMapNode(String key, Integer value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    // method to calculate frequency of words using Hash Table implemented with LinkedList
    public static void calculateWordFrequency(String sentence) {

        // convert sentence to lowercase and split into words
        String[] words = sentence.toLowerCase().split(" ");

        // create empty hash table with size of array
        LinkedList<MyMapNode> hashTable[] = new LinkedList[words.length];
        for (int i = 0; i < words.length; i++) {
            hashTable[i] = new LinkedList<>();
        }

        // iterate through each word in sentence and update hash table
        for (String word : words) {

            // calculate hash code for current word
            int hashCode = Math.abs(word.hashCode() % words.length);

            // search for word in hash table
            LinkedList<MyMapNode> linkedList = hashTable[hashCode];
            MyMapNode mapNode = search(linkedList, word);

            // if word not found, add it to hash table with count of 1
            if (mapNode == null) {
                MyMapNode newNode = new MyMapNode(word, 1);
                linkedList.add(newNode);
            }
            // if word found, increment its count
            else {
                mapNode.value += 1;
            }
        }

        // print frequency of each word
        for (LinkedList<MyMapNode> linkedList : hashTable) {
            for (MyMapNode node : linkedList) {
                System.out.println(node.key + " : " + node.value);
            }
        }
    }

    // method to search for a word in a linked list
    public static MyMapNode search(LinkedList<MyMapNode> linkedList, String word) {
        for (MyMapNode node : linkedList) {
            if (node.key.equals(word)) {
                return node;
            }
        }
        return null;
    }

    // main method to test the code

    }
