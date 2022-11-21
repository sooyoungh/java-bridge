package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.Score;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Referee referee;
    private Bridge bridge;
    private User user;
    private Record record = new Record();
    private Result result = new Result();

    public void createBridge(int bridgeSize) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> randomBridge = bridgeMaker.makeBridge(bridgeSize);
        bridge = new Bridge(randomBridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveDirection) {
        user = new User(moveDirection);
        bridge.addCurrentRoundNumber();
    }

    public void judgeMove(String moveDirection) {
        int currentRoundNumber = bridge.getCurrentRoundNumber();
        referee = new Referee(bridge, currentRoundNumber);

        Score score = referee.judgeMove(moveDirection);
        result.setScore(score);
        record.updateBridgeRecord(score, moveDirection);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        result.addTryCount();
        bridge.resetCurrentRoundNumber();
        record.deleteBridgeRecord();
    }

    public Boolean isFail() {
        String moveDirection = user.getMoveDirection();
        Boolean isFail = referee.isFail(moveDirection);
        if (isFail) {
            bridge.resetCurrentRoundNumber();
        }
        return isFail;
    }

    public Boolean isPass() {
        return !isFail();
    }

    public Boolean isFinalRound() {
        int currentRoundNumber = bridge.getCurrentRoundNumber();
        return bridge.isFinalRound(currentRoundNumber);
    }
}
