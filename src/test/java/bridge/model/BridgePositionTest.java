package bridge.model;

import bridge.constant.Score;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.constant.Score.FAIL;
import static bridge.constant.Score.PASS;
import static org.assertj.core.api.Assertions.assertThat;

class BridgePositionTest {

    BridgePosition bridgeFirst;
    BridgePosition bridgeSecond;
    BridgePosition bridgeFinal;

    @BeforeEach
    void setUp() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        bridgeFirst = new BridgePosition(bridge);
        bridgeSecond = new BridgePosition(bridge);
        bridgeFinal = new BridgePosition(bridge);

        bridgeFirst.addCurrentRoundNumber();
        bridgeSecond.addCurrentRoundNumber();
        bridgeFinal.addCurrentRoundNumber();
        bridgeFinal.addCurrentRoundNumber();
        bridgeFinal.addCurrentRoundNumber();
    }

    @AfterEach
    void afterEach() {
        bridgeFirst = null;
        bridgeSecond = null;
        bridgeFinal = null;
    }

    @DisplayName("이동의 성공/실패 여부를 반환한다.")
    @Test
    void judgeMoveTest() {
        Score scoreFirst = bridgeFirst.judgeMove("D");
        Score scoreSecond = bridgeSecond.judgeMove("U");

        assertThat(scoreFirst).isEqualTo(FAIL);
        assertThat(scoreSecond).isEqualTo(PASS);
    }

    @DisplayName("이동이 실패하는 지 반환한다.")
    @Test
    void isFailTest() {
        Boolean isRecordFirstFail = bridgeFirst.isFail("D");
        Boolean isRecordSecondFail = bridgeSecond.isFail("U");

        assertThat(isRecordFirstFail).isTrue();
        assertThat(isRecordSecondFail).isFalse();
    }
}