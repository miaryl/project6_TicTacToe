package com.tictactoe;

public final class GameDisplay {
    
    private static final String WELCOME_MSG = "¡Bienvenido al Tres en Raya!";
    
    /** Separador visual */
    private static final String SEPARATOR = "===============================";
    
    /** Línea divisoria del tablero */
    private static final String BOARD_DIVIDER = "  -----";
    
    /**
     * Constructor privado para prevenir instanciación.
     * Esta es una clase utilitaria con solo métodos estáticos.
     */
    private GameDisplay() {
        throw new UnsupportedOperationException("Clase utilitaria - no debe ser instanciada");
    }
    
    /**
     * Muestra el mensaje de bienvenida.
     */
    public static void showWelcome() {
        System.out.println(WELCOME_MSG);
        System.out.println("La " + Player.getColoredPlayer(Player.PLAYER_X) + " será morada y la " + 
                          Player.getColoredPlayer(Player.PLAYER_O) + " será azul");
        System.out.println(SEPARATOR);
    }
    
    /**
     * Muestra el tablero de juego.
     * 
     * @param board tablero a mostrar
     */
    public static void showBoard(final GameBoard board) {
        System.out.println("\n  0 1 2");
        
        for (int i = 0; i < GameBoard.SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < GameBoard.SIZE; j++) {
                final char cell = board.getCell(i, j);
                if (cell == GameBoard.EMPTY) {
                    System.out.print(cell + " ");
                } else {
                    // Mostrar el símbolo con color
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
     * 
     * @param player jugador actual
     */
    public static void showPlayerTurn(final char player) {
        System.out.println("\nTurno del " + Player.getColoredPlayerName(player));
    }
    
    /**
     * Muestra mensaje de movimiento inválido.
     * 
     * @param row fila intentada
     * @param col columna intentada
     * @param board tablero actual
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
     * @param winner símbolo del jugador ganador
     */
    public static void showWinner(final char winner) {
        final String TEXT_BG_GREEN = "\u001B[42m";
        final String TEXT_RESET    = "\u001B[0m";

        System.out.println(SEPARATOR);
        System.out.println("\n" + TEXT_BG_GREEN + "🎉 ¡Felicidades! El " + 
                          Player.getPlayerName(winner) + " (" + Player.getColoredPlayer(winner) + 
                          ") ha ganado!" + TEXT_RESET + "\n");
        System.out.println(SEPARATOR);
    }
    
    /**
     * Muestra el mensaje de empate.
     */
    public static void showTie() {
        final String TEXT_BG_YELLOW = "\u001B[43m";
        final String TEXT_BLACK = "\u001B[30m";
        final String TEXT_RESET = "\u001B[0m";
        
        System.out.println(SEPARATOR);
        System.out.println("\n" + TEXT_BG_YELLOW + TEXT_BLACK + 
                          " ¡Es un empate! El tablero está lleno. " + TEXT_RESET + "\n");
        System.out.println(SEPARATOR);
    }
    
    /**
     * Muestra el mensaje de despedida.
     */
    public static void showGoodbye() {
        System.out.println("\n ¡Gracias por jugar!");
        System.out.println("¡Hasta la próxima! 🎮");
    }
    
    /**
     * Muestra las instrucciones del juego.
     */
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