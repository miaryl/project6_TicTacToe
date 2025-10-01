package com.tictactoe;

public final class GameBoard {
    
    public static final int SIZE = 3;
    public static final char EMPTY = '-';
    private final char[][] board;
    
    
    public GameBoard() {
        this.board = new char[SIZE][SIZE];
        initializeBoard();
    }
    
   
    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }
    
    /**
     * Obtiene el valor de una celda específica.
     * @param row 
     * @param col
     * @return 
     * @throws IllegalArgumentException 
     */
    public char getCell(final int row, final int col) {
        if (!isValidPosition(row, col)) {
            throw new IllegalArgumentException("Posición inválida: (" + row + ", " + col + ")");
        }
        return board[row][col];
    }
    
    /**
     * Establece el valor de una celda específica.
     * @param row 
     * @param col 
     * @param symbol 
     * @return
     */
    public boolean setCell(final int row, final int col, final char symbol) {
        if (isValidPosition(row, col) && isEmpty(row, col)) {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }
    
    /**
     * Verifica si una posición es válida.
     * @param row 
     * @param col 
     * @return 
     */
    public boolean isValidPosition(final int row, final int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }
    
    /**
     * Verifica si una celda está vacía.
     * 
     * @param row 
     * @param col 
     * @return 
     */
    public boolean isEmpty(final int row, final int col) {
        return isValidPosition(row, col) && board[row][col] == EMPTY;
    }
    
    /**
     * Verifica si el tablero está lleno.
     * 
     * @return 
     */
    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}