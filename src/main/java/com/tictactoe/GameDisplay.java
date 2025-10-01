package com.tictactoe;

public final class GameDisplay {
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_RESET  = "\u001B[0m";
    
    private static final String WELCOME_MSG = "¡Bienvenido al Tres en Raya!";
    
    
    private static final String SEPARATOR = "===============================";
    
    
    private static final String BOARD_DIVIDER = TEXT_YELLOW +  "\t  -----" + TEXT_RESET;
    
    
    private GameDisplay() {
        throw new UnsupportedOperationException("Clase utilitaria - no debe ser instanciada");
    }
    
   
    public static void showWelcome() {
        System.out.println(WELCOME_MSG);
        System.out.println("La " + Player.getColoredPlayer(Player.PLAYER_X) + " será morada y la " + 
                          Player.getColoredPlayer(Player.PLAYER_O) + " será azul");
        System.out.println(SEPARATOR);
    }
    
    /**
     * Muestra el tablero de juego.
     * @param board
     */
    public static void showBoard(final GameBoard board) {
        System.out.println("\n \t  0 1 2");
        
        for (int i = 0; i < GameBoard.SIZE; i++) {
            System.out.print("\t" + i + " ");
            for (int j = 0; j < GameBoard.SIZE; j++) {
                final char cell = board.getCell(i, j);
                if (cell == GameBoard.EMPTY) {
                    System.out.print(cell + " ");
                } else {
                    System.out.print(Player.getColoredPlayer(cell) + " ");
                }
            }
            System.out.println();
            
            if (i < GameBoard.SIZE - 1) {
                System.out.println(BOARD_DIVIDER);
            }
        }
        System.out.println();
    }
    
    /**
     * Muestra de quién es el turno.
     * @param player
     */
    public static void showPlayerTurn(final char player) {
        System.out.println("\nTurno del " + Player.getColoredPlayerName(player));
    }
    
    /**
     * Muestra mensaje de movimiento inválido.
     * 
     * @param row 
     * @param col 
     * @param board 
     */
    public static void showInvalidMoveMessage(final int row, final int col, final GameBoard board) {
        final String TEXT_BG_RED    = "\u001B[41m";
        final String TEXT_RESET  = "\u001B[0m";

        if (!board.isValidPosition(row, col)) {
            System.out.println( "\n" + TEXT_BG_RED +  " Posición inválida! Usa un número entre el 0 y el 2." + TEXT_RESET + "\n");
        } else if (!board.isEmpty(row, col)) {
            System.out.println( "\n" + TEXT_BG_RED + " Esa celda ya está ocupada! Prueba con otra." + TEXT_RESET  + "\n");
        }
    }
    
    /**
     * Muestra el mensaje de ganador.
     * 
     * @param winner 
     */
    public static void showWinner(final char winner) {
        final String TEXT_BG_GREEN = "\u001B[42m";
        final String TEXT_RESET    = "\u001B[0m";

        System.out.println(SEPARATOR);
        System.out.println("\n" + TEXT_BG_GREEN + "¡Felicidades! El " + 
                          Player.getPlayerName(winner) + " (" + Player.getColoredPlayer(winner) + TEXT_BG_GREEN + ") ha ganado!" + TEXT_RESET + "\n");
        System.out.println(SEPARATOR);
    }
    
    public static void showTie() {
        final String TEXT_BRIGHT_BG_BLUE   = "\u001B[104m";
        final String TEXT_BLACK = "\u001B[30m";
        final String TEXT_RESET = "\u001B[0m";
        
        System.out.println(SEPARATOR);
        System.out.println("\n" + TEXT_BRIGHT_BG_BLUE + TEXT_BLACK + 
                          " ¡Es un empate! El tablero está lleno. " + TEXT_RESET + "\n");
        System.out.println(SEPARATOR);
    }
    
 
    public static void showGoodbye() {
        System.out.println("\n¡Gracias por jugar!");
        System.out.println("¡Hasta la próxima! ");
    }
    

    public static void showInstructions() {
        System.out.println("\n Instrucciones:");
        System.out.println("- El tablero usa coordenadas de 0 a 2");
        System.out.println("- Introduce primero la fila, luego la columna");
        System.out.println("- El objetivo es conseguir tres símbolos en línea");
        System.out.println("- Puede ser horizontal, vertical o diagonal");
        System.out.println("- La " + Player.getColoredPlayer(Player.PLAYER_X) + " es morada y la " + 
                          Player.getColoredPlayer(Player.PLAYER_O) + " es azul\n");
    }
}