package state.ex4;

public class UrgentState implements State {
    private static UrgentState instance = new UrgentState();

    private UrgentState() {

    }

    public static State getInstance() {
        return instance;
    }

    @Override
    public void doClock(Context context, int hour) {

    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("紧急：紧急情况下使用金库！");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃（紧急情况）");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("紧急情况的通话录音");
    }

    public String toString() {
        return "[ 紧急情况 ]";
    }
}
