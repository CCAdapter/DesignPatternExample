package state.ex3;

public class MidDayState implements State {
    private static MidDayState singleton = new MidDayState();

    private MidDayState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour >= 9 && hour < 12 || hour >= 13 && hour < 17) {
            context.changeState(DayState.getInstance());
        } else if (hour < 9 || hour >= 17) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("紧急：中午使用金库！");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃（中午）");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("中午的通话录音");
    }

    public String toString() {
        return "[ 中午 ]";
    }
}
