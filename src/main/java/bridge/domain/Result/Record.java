package bridge.domain.Result;

import bridge.constant.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Record {

    List<String> upBridgeRecord;
    List<String> downBridgeRecord;

    Record() {
        upBridgeRecord = new ArrayList<>();
        downBridgeRecord = new ArrayList<>();
    }

    public List<List<String>> getBridgeRecord() {
        List<List<String>> record = new ArrayList<>();
        record.add(upBridgeRecord);
        record.add(downBridgeRecord);
        return Collections.unmodifiableList(record);
    }

    public void updateBridgeRecord(Direction direction, String moveResult) {
        if (direction == Direction.UP) {
            upBridgeRecord.add(moveResult);
            return;
        }
        downBridgeRecord.add(moveResult);
    }
}