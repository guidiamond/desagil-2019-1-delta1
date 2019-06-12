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
        Random gerador = new Random();
        Element element = new Element(row, col);
        // Maior e menor valor do sistema (cima | baixo | esquerda | direita)
        int max = 1;
        int min = -1;
        // https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
        int geradorRow = gerador.nextInt((max - (min)) + 1) + (min);
        int geradorCol = gerador.nextInt((max - (min)) + 1) + (min);

        int nextRandomRow = row + geradorRow;
        int nextRandomCol = col + geradorCol;

        // Checa se objeto esta no final do mapa | parede
        if (!board.isWall(nextRandomRow, nextRandomCol) &&
                nextRandomRow > 0 &&
                nextRandomRow < board.getNumRows() &&
                nextRandomCol < board.getNumCols() &&
                nextRandomCol > 0) {
            move(geradorRow, geradorCol);
        }
    }


}