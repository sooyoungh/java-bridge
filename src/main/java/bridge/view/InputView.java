package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private String INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    private String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private String COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_MESSAGE);
        String bridgeNumber = Console.readLine();
        // 검증
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_MESSAGE);
        String move = Console.readLine();
        // 검증
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(COMMAND_MESSAGE);
        String gameCommand = Console.readLine();
        // 검증
        return null;
    }
}
