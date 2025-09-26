package com.tictactoe;

public final class Player {
    
    /** Símbolo del jugador X */
    public static final char PLAYER_X = 'X';
    
    /** Símbolo del jugador O */
    public static final char PLAYER_O = 'O';
    
    /**
     * Constructor privado para prevenir instanciación.
     * Esta es una clase utilitaria con solo métodos estáticos.
     */
    private Player() {
        throw new UnsupportedOperationException("Clase utilitaria - no debe ser instanciada");
    }
    
    /**
     * Obtiene el jugador contrario.
     * 
     * @param currentPlayer jugador actual
     * @return el otro jugador
     * @throws IllegalArgumentException si el jugador no es válido
     */
    public static char getOtherPlayer(final char currentPlayer) {
        if (currentPlayer == PLAYER_X) {
            return PLAYER_O;
        } else if (currentPlayer == PLAYER_O) {
            return PLAYER_X;
        } else {
            throw new IllegalArgumentException("Jugador inválido: " + currentPlayer);
        }
    }
    
    /**
     * Verifica si el símbolo corresponde a un jugador válido.
     * 
     * @param player símbolo del jugador
     * @return true si es válido, false si no
     */
    public static boolean isValidPlayer(final char player) {
        return player == PLAYER_X || player == PLAYER_O;
    }
    
    /**
     * Obtiene el nombre del jugador basado en su símbolo.
     * 
     * @param player símbolo del jugador
     * @return nombre del jugador
     * @throws IllegalArgumentException si el jugador no es válido
     */
    public static String getPlayerName(final char player) {
        if (player == PLAYER_X) {
            return "Jugador X";
        } else if (player == PLAYER_O) {
            return "Jugador O";
        } else {
            throw new IllegalArgumentException("Jugador inválido: " + player);
        }
    }
}