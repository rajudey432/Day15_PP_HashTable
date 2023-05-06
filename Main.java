package com.bridgelabz.HashTables;

import static com.bridgelabz.HashTables.WordFrequency.calculateWordFrequency;

public class Main {
    public static void main(String[] args) {
        System.out.println("");
        String sentence = "To be or not to be";
        calculateWordFrequency(sentence);
    }
}
