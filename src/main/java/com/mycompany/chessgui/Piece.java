
package com.mycompany.chessgui;

/**
 *
 * @author Adreno
 */
public class Piece {
    public boolean black;
    public Character symbol;

    public Piece(Character color, Character symbol) {
        this.black = (color == 'b');
        this.symbol = symbol;
    }
    
    
}
