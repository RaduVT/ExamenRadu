import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Chess {

    class Piece {
        public static final String BLACK_KING = "♚";
        public static final String BLACK_QUEEN= "♛";
        public static final String BLACK_BISHOP = "♝";
        public static final String BLACK_TOWER = "♜";
        public static final String BLACK_HORSE = "♞";
        public static final String BLACK_PAWN = "♟";
        public static final String WHITE_KING = "♔";
        public static final String WHITE_QUEEN= "♕";
        public static final String WHITE_BISHOP = "♗";
        public static final String WHITE_TOWER = "♖";
        public static final String WHITE_HORSE = "♘";
        public static final String WHITE_PAWN = "♙";

        int color;
        int type;

        @Override
        public String toString() {
            String s = "";

            if (color == 0) {
                switch (type) {
                    case 0: s += BLACK_PAWN ;
                        break;
                    case 1: s += BLACK_TOWER;
                        break;
                    case 2: s += BLACK_HORSE;
                        break;
                    case 3: s += BLACK_BISHOP;
                        break;
                    case 4: s += BLACK_QUEEN;
                        break;
                    case 5: s += BLACK_KING;
                }
            } else if (color == 1) {
                switch (type) {
                    case 0: s += WHITE_PAWN ;
                        break;
                    case 1: s += WHITE_TOWER;
                        break;
                    case 2: s += WHITE_HORSE;
                        break;
                    case 3: s += WHITE_BISHOP;
                        break;
                    case 4: s += WHITE_QUEEN;
                        break;
                    case 5: s += WHITE_KING;
                }
            }
            return s;
        }
    }

    class Board {

            private Map<Position, Piece> pieces;

            public Board() {
                pieces = new HashMap<>();
                readMapFromFile("initials.csv");
            }

            private void readMapFromFile(String fileName) {
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    int row = 0;
                    while ((line = br.readLine()) != null) {
                        String[] values = line.split(",");
                        for (int col = 0; col < values.length; col++) {
                            Position position = new Position(row, col);
                            Piece piece = Piece.fromSymbol(values[col]);
                            if (piece != null) {
                                pieces.put(position, piece);
                            }
                        }
                        row++;
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }
            }

            public Piece getPiece(Position position) {
                return pieces.get(position);
            }

            public void setPiece(Position position, Piece piece) {
                pieces.put(position, piece);
            }

        @Override
        public String toString() {
            String s = "";
            return s;
        }
    }
}


