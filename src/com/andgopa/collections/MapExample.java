package com.andgopa.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andres Gonzalez on 11/30/17
 */
public class MapExample {

    public static void main(String[] args) {
        Map<String, String> language = new HashMap<>();
        language.put("Java", "compile high level, object-oriented, platform independant language");
        language.put("Phyton", "interpreted, object-oriented, high-level programming language with dynamic semantics");
        language.put("Algol", "an algorithmic language");
        language.put("BASIC", "Beginners all Purposes symbolic Instruction Code");

        System.out.println(language.get("Java"));
        language.put("Java", "this course is about Java");
        System.out.println(language.get("Java"));
    }
}
