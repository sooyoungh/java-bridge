package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class Bridge {

    private List<String> bridge;

    public List<String> createRandomBridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        bridge =  bridgeMaker.makeBridge(size);
        return bridge;
    }

    public String getDirectionByPosition(int position) {
        return bridge.get(position);
    }
}