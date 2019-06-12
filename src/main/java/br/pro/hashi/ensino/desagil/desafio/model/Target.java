package br.pro.hashi.ensino.desagil.desafio.model;

import java.util.Random;

public class Target extends Element {
    private final Board board;

    public Target(int row, int col, Board board) {
        super(row, col);
        this.board = board;
    }

    public void move(int rowShift, int colShift) {
        row += rowShift;
        col += colShift;
    }

    public void moveRandom() {
        Random generator = new Random();
        Element element = new Element(row, col);

        // Maior e menor valor do sistema (cima | baixo | esquerda | direita)
        int max = 1;
        int min = -1;

        // Gerador aleatorio de (1 | -1)
        // https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
        int rowGenerator = generator.nextInt((max - (min)) + 1) + (min);
        int colGenerator = generator.nextInt((max - (min)) + 1) + (min);

        // Proximo Movimento
        int nextRow = row + rowGenerator;
        int nextCol = col + colGenerator;

        if (nextRow > 0 &&
            nextRow < board.getNumRows() &&
            nextCol > 0 &&
            nextCol < board.getNumCols() &&
            !board.isWall(nextRow, nextCol)) {
                move(rowGenerator, colGenerator);
        }
    }
}