package bridge.constant;

import java.util.Objects;
import java.util.stream.Stream;

public enum Direction {
    UP("U", 1),
    DOWN("D", 0);

    private String message;
    private int position;

    Direction (String message, int position) {
        this.message = message;
        this.position = position;
    }

    public static String findMessageByPosition(int position) {
        return Objects.requireNonNull(Stream.of(values())
                .filter(i -> i.position == position)
                .findFirst()
                .orElse(null))
                .message;
    }
}