package leaderbord;

import java.util.Arrays;

enum Points {

    FIRST(25),
    SECOND(18),
    THIRD(15);

    final private int points;

    Points(int points) {
        this.points = points;
    }

    static int forPosition(int position) {
        return Arrays.stream(values())
                .filter(e -> e.ordinal() == position)
                .findFirst()
                .map(e -> e.points)
                .orElse(0);
    }
}
