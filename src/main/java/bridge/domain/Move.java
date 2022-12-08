package bridge.domain;

import bridge.constant.Direction;

public class Move {

    private Direction moveDirection;
    private Boolean isMovePass;

    public Direction move(String inputMove) {
        moveDirection = Direction.getDirectionByMessage(inputMove);
        return moveDirection;
    }
}