package com.bridgelabz.HashTables;

import java.util.*;

import java.util.*;

public class RemoveWordFromPhrase {
    public static void main(String[] args) {
        String phrase = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        String[] words = phrase.split(" ");

        Map<Integer, LinkedList<MyMapNode>> hashTable = new HashMap<>();
        for (String word : words) {
            int index = Math.abs(word.hashCode()) % 10;
            LinkedList<MyMapNode> linkedList = hashTable.getOrDefault(index, new LinkedList<MyMapNode>());
            MyMapNode node = findNode(linkedList, word);
            if (node != null) {
                node.setValue(node.getValue() + 1);
            } else {
                node = new MyMapNode(word, 1);
                linkedList.add(node);
            }
            hashTable.put(index, linkedList);
        }

        LinkedList<MyMapNode> linkedListToRemove = hashTable.getOrDefault(Math.abs("avoidable".hashCode()) % 10, new LinkedList<MyMapNode>());
        MyMapNode nodeToRemove = findNode(linkedListToRemove, "avoidable");
        if (nodeToRemove != null) {
            linkedListToRemove.remove(nodeToRemove);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            LinkedList<MyMapNode> linkedList = hashTable.getOrDefault(i, new LinkedList<MyMapNode>());
            for (MyMapNode node : linkedList) {
                sb.append(node.getKey()).append(":").append(node.getValue()).append(" ");
            }
        }

        String newPhrase = sb.toString().trim();
        System.out.println(newPhrase);
    }

    private static MyMapNode findNode(LinkedList<MyMapNode> linkedList, String word) {
        for (MyMapNode node : linkedList) {
            if (node.getKey().equals(word)) {
                return node;
            }
        }
        return null;
    }

    private static class MyMapNode {
        private String key;
        private int value;

        public MyMapNode(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}

