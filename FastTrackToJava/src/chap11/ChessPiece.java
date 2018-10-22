package chap11;

import java.util.EnumSet;

public class ChessPiece {
    public static enum Figure {KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN};
    public static enum Color { WHITE, BLACK };

    private final Color color;
    private final Figure figure;

    public ChessPiece(Color color, Figure figure) {
        this.color = color;
        this.figure = figure;
    }

    public Figure getFigure() {
        return this.figure;
    }

    public Color getColor() {
        return this.color;
    }

    public String toString() {
        return this.color + " " + this.figure;
    }

    public static void main(String... args) {

        for (Figure next : EnumSet.allOf(Figure.class))
            for (Color nextColor : EnumSet.range(Color.WHITE, Color.BLACK))
                System.out.println(next.name() + "/" + nextColor.name());
    }
}