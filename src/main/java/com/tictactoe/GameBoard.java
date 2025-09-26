package com.tictactoe;

public final class GameBoard {
    
    /** Tamaño del tablero (3x3) */
    public static final int SIZE = 3;
    
    /** Símbolo para celda vacía */
    public static final char EMPTY = '-';
    
    /** Tablero de juego */
    private final char[][] board;
    
    /**
     * Constructor que inicializa un tablero vacío.
     */
    public GameBoard() {
        this.board = new char[SIZE][SIZE];
        initializeBoard();
    }
    
    /**
     * Inicializa el tablero con celdas vacías.
     */
    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }
    
    /**
     * Obtiene el valor de una celda específica.
     * 
     * @param row fila (0-2)
     * @param col columna (0-2)
     * @return el carácter en esa posición
     * @throws IllegalArgumentException si las coordenadas son inválidas
     */
    public char getCell(final int row, final int col) {
        if (!isValidPosition(row, col)) {
            throw new IllegalArgumentException("Posición inválida: (" + row + ", " + col + ")");
        }
        return board[row][col];
    }
    
    /**
     * Establece el valor de una celda específica.
     * 
     * @param row fila (0-2)
     * @param col columna (0-2)
     * @param symbol símbolo a colocar
     * @return true si se pudo colocar, false si no
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
     * 
     * @param row fila
     * @param col columna
     * @return true si es válida, false si no
     */
    public boolean isValidPosition(final int row, final int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }
    
    /**
     * Verifica si una celda está vacía.
     * 
     * @param row fila
     * @param col columna
     * @return true si está vacía, false si no
     */
    public boolean isEmpty(final int row, final int col) {
        return isValidPosition(row, col) && board[row][col] == EMPTY;
    }
    
    /**
     * Verifica si el tablero está lleno.
     * 
     * @return true si está lleno, false si no
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