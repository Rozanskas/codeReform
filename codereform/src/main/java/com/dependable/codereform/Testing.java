package com.dependable.codereform;

import java.util.Arrays;

public class Testing {
    public static void main(String[] args) {
        // expected -> 1237, 8, 199

        String str = "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        String name;\n" +
                "        int res = number * name.length();\n" +
                "\n" +
                "        System.out.println(res);\n" +
                "    }\n" +
                "}".replaceAll("\t", "");
        str = str.replaceAll("[^-?0-9]+", " ");
        System.out.println(Arrays.asList(str.trim().split(" ")).size());
    }
}
