public class TvDevice implements Device {

    @Override
    public String applySettings(boolean powerOn, int volume) {
        return "TV | power=" + (powerOn ? "ON" : "OFF") + " | volume=" + volume;
    }
}