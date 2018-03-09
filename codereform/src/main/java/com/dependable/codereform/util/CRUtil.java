
package com.dependable.codereform.util;

import com.dependable.codereform.model.CRDocument;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CRUtil {
    private static final String OPERATOR_FOUND = "X";

    private static final String METHOD_MATCHER = "(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])";
    private static final String NUMBER_MATCHER = "[^-?0-9]+";
    private static final String VARIABLE_MATCHER = "\"[^\"]*\"|((?=_[a-z_0-9]|[a-z])[a-z_0-9]+(?=\\s*=))";
    private Set<String> distinctOperands = new HashSet<>();

    public CRUtil() {
        //
    }

    private final String[] operators = {
            "=", "+", "-", "*", "/", "%"
    };

    private final String[] dataTypes = {
            "int", "double", "float", "String", "char", "byte", "boolean", "void"
    };

    private final String[] numbers = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9"
    };

    public int countLines(CRDocument document) {
        return document.getContent().split("\n").length;
    }

    public int countDistinctOperators(CRDocument document) {
        String[] _operators = Arrays.copyOf(operators, operators.length);

        char[] characters = document.getContent().toCharArray();
        for (char character : characters) {
            for (int j = 0; j < _operators.length; j++) {
                if (String.valueOf(character).equals(_operators[j])) {
                    _operators[j] = OPERATOR_FOUND;
                    break;
                }
            }
        }

        int result = 0;
        for (String _operator : _operators) {
            if (_operator.equals(OPERATOR_FOUND)) {
                result++;
            }
        }

        return result;
    }

    public int countTotalOperators(CRDocument document) {
        int result = 0;
        char[] characters = document.getContent().toCharArray();
        for (char character : characters) {
            for (String operator : operators) {
                if (String.valueOf(character).equals(operator)) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }

    public int countDistinctOperands(CRDocument document) {
        return this.distinctOperands.size();
    }

    public int countTotalOperands(CRDocument document) {
        int result = 0;
        String[] lines = document.getContent().split("\n");
        for (String currentLine : lines) {
            result += getNumberOfOperand("number", currentLine);
            result += getNumberOfOperand("method", currentLine);
            result += getNumberOfOperand("variable", currentLine);
        }
        return result;
    }

    // this was done during refactoring *
    private int getNumberMatches(String matcherType, String currentLine) {
        int result = 0;
        Pattern pattern = Pattern.compile(matcherType);
        Matcher matcher = pattern.matcher(currentLine);
        while (matcher.find()) {
            this.distinctOperands.add(matcher.group());
            result++;
        }

        return result;
    }

    private int getNumberOfOperand(String type, String currentLine) {
        int result = 0;
        switch (type) {
            case "method":
                result += getNumberMatches(METHOD_MATCHER, currentLine);
                break;
            case "number":
                String str = currentLine.replaceAll(NUMBER_MATCHER, " ");
                String[] tokens = str.trim().split(" ");
                for (String token : tokens) {
                    if (token.length() != 0) {
                        this.distinctOperands.add(token);
                        result++;
                    }
                }
                break;
            case "variable":
                result += getNumberMatches(VARIABLE_MATCHER, currentLine);
                break;
        }

        return result;
    }
}
