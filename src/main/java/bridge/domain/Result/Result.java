package bridge.domain.Result;

import java.util.List;

public class Result {
    private int tryCount;
    private final Record record;

    Result() {
        tryCount = 0;
        record = new Record();
    }

    public void addTryCount () {
        tryCount += 1;
    }

    public List<List<String>> getBridgeRecord () {
        return record.getBridgeRecord();
    }

    public int getTryCount () {
        return tryCount;
    }
}