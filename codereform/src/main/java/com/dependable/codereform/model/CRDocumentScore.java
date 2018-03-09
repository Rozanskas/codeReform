package com.dependable.codereform.model;

public class CRDocumentScore {
    private int numberLines;
//    private int totalNumberOperators;
//    private int totalNumberOperands;
//    private int numberDistinctOperators;
//    private int numberDistinctOperands;

    private double volume;
    private double difficulty;
    private double effort;
    private int vocabulary;
    private int length;
    private int calculatedLength;
    private double timeRequiredToProgram;
    private double numberDeliveredBugs;

    public CRDocumentScore() {
        //
    }

    public CRDocumentScore(int numberLines, double volume, double difficulty, double effort, int vocabulary, int length, int calculatedLength, double timeRequiredToProgram, double numberDeliveredBugs) {
        this.numberLines = numberLines;
        this.volume = volume;
        this.difficulty = difficulty;
        this.effort = effort;
        this.vocabulary = vocabulary;
        this.length = length;
        this.calculatedLength = calculatedLength;
        this.timeRequiredToProgram = timeRequiredToProgram;
        this.numberDeliveredBugs = numberDeliveredBugs;
    }

    public void setTimeRequiredToProgram(double timeRequiredToProgram) {
        this.timeRequiredToProgram = timeRequiredToProgram;
    }

    public double getTimeRequiredToProgram() {
        return timeRequiredToProgram;
    }

    public void setNumberDeliveredBugs(double numberDeliveredBugs) {
        this.numberDeliveredBugs = numberDeliveredBugs;
    }

    public double getNumberDeliveredBugs() {
        return numberDeliveredBugs;
    }

    public int getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(int vocabulary) {
        this.vocabulary = vocabulary;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCalculatedLength() {
        return calculatedLength;
    }

    public void setCalculatedLength(int calculatedLength) {
        this.calculatedLength = calculatedLength;
    }

    public int getNumberLines() {
        return numberLines;
    }

    public void setNumberLines(int numberLines) {
        this.numberLines = numberLines;
    }
//
//    public int getTotalNumberOperators() {
//        return totalNumberOperators;
//    }
//
//    public void setTotalNumberOperators(int totalNumberOperators) {
//        this.totalNumberOperators = totalNumberOperators;
//    }
//
//    public int getTotalNumberOperands() {
//        return totalNumberOperands;
//    }
//
//    public void setTotalNumberOperands(int totalNumberOperands) {
//        this.totalNumberOperands = totalNumberOperands;
//    }
//
//    public int getNumberDistinctOperators() {
//        return numberDistinctOperators;
//    }
//
//    public void setNumberDistinctOperators(int numberDistinctOperators) {
//        this.numberDistinctOperators = numberDistinctOperators;
//    }
//
//    public int getNumberDistinctOperands() {
//        return numberDistinctOperands;
//    }
//
//    public void setNumberDistinctOperands(int numberDistinctOperands) {
//        this.numberDistinctOperands = numberDistinctOperands;
//    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public double getEffort() {
        return effort;
    }

    public void setEffort(double effort) {
        this.effort = effort;
    }

    @Override
    public String toString() {
        return this.numberLines + "\n" +
                this.length + "\n" +
                this.calculatedLength + "\n" +
                this.vocabulary + "\n" +
                this.difficulty + "\n" +
                this.volume + "\n" +
                this.effort + "\n" +
                this.timeRequiredToProgram + "\n" +
                this.numberDeliveredBugs + "\n";
    }
}
