package bridge.constant;

public enum GameCommand {
    RESTART("R"),
    QUIT("Q");

    private String message;

    GameCommand (String message) {
        this.message = message;
    }

    public static Boolean isGameRestart(String message) {
        return message.equals(RESTART.message);
    }
}