package Mastermind;

import java.util.List;
import java.util.stream.Stream;

enum Peg {
    RED,
    BLUE,
    YELLOW,
    GREEN,
    WHITE,
    BLACK;

    public static List<String> getAllValues() {
        return Stream.of(Peg.values())
                .map(Enum::name)
                .map(String::toLowerCase)
                .toList();
    }
}
