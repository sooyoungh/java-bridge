package bridge.domain;

import bridge.constant.Direction;

public class BridgePosition {

    private Bridge bridge;
    private int position;

    public BridgePosition (Bridge bridge) {
        this.bridge = bridge;
        position = 0;
    }

    public Direction getDirectionByPosition() {
        String bridgeMessage = bridge.getDirectionByPosition(position);
        return Direction.getDirectionByMessage(bridgeMessage);
    }
}