package com.tictactoe;
import java.util.Scanner;
import java.util.InputMismatchException;

public final class TicTacToe {
    
    private TicTacToe() {
        // Constructor privado para clase utilitaria
    }
    
    public static void main(final String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final GameBoard board = new GameBoard();
            
            char currentPlayer = Player.PLAYER_X;
            
            GameDisplay.showWelcome();
            GameDisplay.showBoard(board);
            
            while (true) {
                final char playerBeforeMove = currentPlayer;
                
                // Hacer movimiento
                if (makePlayerMove(scanner, board, currentPlayer)) {
                    GameDisplay.showBoard(board);
                    
                    // Comprobar si hay ganador
                    if (GameLogic.checkWinner(board)) {
                        GameDisplay.showWinner(playerBeforeMove);
                        break;
                    }
                    
                    // Comprobar si hay empate
                    if (GameLogic.isBoardFull(board)) {
                        GameDisplay.showTie();
                        break;
                    }
                    
                    // Cambiar de jugador
                    currentPlayer = Player.getOtherPlayer(currentPlayer);
                }
            }
            
            GameDisplay.showGoodbye();
        }
    }
    
    /**
     * Maneja el movimiento de un jugador hasta que sea válido.
     * 
     * @param scanner scanner para entrada de usuario
     * @param board tablero del juego
     * @param currentPlayer jugador actual
     * @return true cuando se hace un movimiento válido
     */
    private static boolean makePlayerMove(final Scanner scanner, final GameBoard board, 
                                        final char currentPlayer) {
        GameDisplay.showPlayerTurn(currentPlayer);
        
        try {
            System.out.print("Introduce la fila (0-2): ");
            final int row = scanner.nextInt();
            System.out.print("Introduce la columna (0-2): ");
            final int col = scanner.nextInt();
            
            if (GameLogic.makeMove(board, row, col, currentPlayer)) {
                return true;
            } else {
                GameDisplay.showInvalidMoveMessage(row, col, board);
                return false;
            }
        } catch (final InputMismatchException e) {
            System.out.println("\n Error: Por favor introduce solo números enteros.");
            scanner.nextLine(); // Limpiar el buffer del scanner
            return false;
        }
    }
}