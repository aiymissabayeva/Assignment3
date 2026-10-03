public class ProjectorDevice implements Device {

    @Override
    public String applySettings(boolean powerOn, int volume) {
        return "PROJECTOR | power=" + (powerOn ? "ON" : "OFF") + " | volume=" + volume;
    }
}