public class RadioDevice implements Device {

    @Override
    public String applySettings(boolean powerOn, int volume) {
        return "RADIO | power=" + (powerOn ? "ON" : "OFF") + " | volume=" + volume;
    }
}