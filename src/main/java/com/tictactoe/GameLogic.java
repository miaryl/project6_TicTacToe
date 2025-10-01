package com.tictactoe;

public final class GameLogic {
    
    
    private GameLogic() {
        throw new UnsupportedOperationException("Clase utilitaria - no debe ser instanciada");
    }
    
    /**
     * Realiza un movimiento en el tablero.
     * 
     * @param board 
     * @param row 
     * @param col 
     * @param player 
     * @return 
     */
    public static boolean makeMove(final GameBoard board, final int row, final int col, final char player) {
        if (!Player.isValidPlayer(player)) {
            return false;
        }
        return board.setCell(row, col, player);
    }
    
    /**
     * Comprueba si hay un ganador en el tablero.
     * 
     * @param board 
     * @return 
     */
    public static boolean checkWinner(final GameBoard board) {
        return checkRows(board) || checkColumns(board) || checkDiagonals(board);
    }
    
    /**
     * Comprueba si las filas tienen tres símbolos iguales.
     * 
     * @param board 
     * @return 
     */
    private static boolean checkRows(final GameBoard board) {
        for (int i = 0; i < GameBoard.SIZE; i++) {
            final char first = board.getCell(i, 0);
            if (first != GameBoard.EMPTY && 
                first == board.getCell(i, 1) && 
                first == board.getCell(i, 2)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Comprueba si las columnas tienen tres símbolos iguales.
     * 
     * @param board 
     * @return 
     */
    private static boolean checkColumns(final GameBoard board) {
        for (int j = 0; j < GameBoard.SIZE; j++) {
            final char first = board.getCell(0, j);
            if (first != GameBoard.EMPTY && 
                first == board.getCell(1, j) && 
                first == board.getCell(2, j)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Comprueba si las diagonales tienen tres símbolos iguales.
     * 
     * @param board 
     * @return 
     */
    private static boolean checkDiagonals(final GameBoard board) {
        final char center = board.getCell(1, 1);
        if (center != GameBoard.EMPTY) {
            if (center == board.getCell(0, 0) && center == board.getCell(2, 2)) {
                return true;
            }
            if (center == board.getCell(0, 2) && center == board.getCell(2, 0)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Comprueba si el tablero está lleno (empate).
     * 
     * @param board 
     * @return 
     */
    public static boolean isBoardFull(final GameBoard board) {
        return board.isFull();
    }
    
    /**
     * Verifica si un movimiento es válido.
     * 
     * @param board tablero del juego
     * @param row fila
     * @param col columna
     * @return true si es válido, false si no
     */
    public static boolean isValidMove(final GameBoard board, final int row, final int col) {
        return board.isValidPosition(row, col) && board.isEmpty(row, col);
    }
    
    /**
     * Obtiene el símbolo ganador si existe.
     * 
     * @param board tablero del juego
     * @return el símbolo del ganador o 0 si no hay ganador
     */
    public static char getWinnerSymbol(final GameBoard board) {
        if (!checkWinner(board)) {
            return 0;
        }
        
        // Verificar filas
        for (int i = 0; i < GameBoard.SIZE; i++) {
            final char first = board.getCell(i, 0);
            if (first != GameBoard.EMPTY && 
                first == board.getCell(i, 1) && 
                first == board.getCell(i, 2)) {
                return first;
            }
        }
        
        // Verificar columnas
        for (int j = 0; j < GameBoard.SIZE; j++) {
            final char first = board.getCell(0, j);
            if (first != GameBoard.EMPTY && 
                first == board.getCell(1, j) && 
                first == board.getCell(2, j)) {
                return first;
            }
        }
        
        // Verificar diagonales
        final char center = board.getCell(1, 1);
        if (center != GameBoard.EMPTY) {
            if (center == board.getCell(0, 0) && center == board.getCell(2, 2)) {
                return center;
            }
            if (center == board.getCell(0, 2) && center == board.getCell(2, 0)) {
                return center;
            }
        }
        
        return 0;
    }
}