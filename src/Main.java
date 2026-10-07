public class Main {

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--demo")) {
            runDemo();
        }
    }

    private static void runDemo() {
        int passed = 0;

        Remote basicTv = new BasicRemote("R1", new TvDevice());
        String result1 = basicTv.execute();
        String expected1 = "TV | power=ON | volume=30";
        if (result1.equals(expected1)) {
            passed++;
            System.out.println("T1 PASS | BasicRemote + TvDevice | result=" + result1);
        } else {
            System.out.println("T1 FAIL | expected=" + expected1 + " | actual=" + result1);
        }

        Remote basicRadio = new BasicRemote("R2", new RadioDevice());
        String result2 = basicRadio.execute();
        String expected2 = "RADIO | power=ON | volume=30";
        if (result2.equals(expected2)) {
            passed++;
            System.out.println("T2 PASS | BasicRemote + RadioDevice | result=" + result2);
        } else {
            System.out.println("T2 FAIL | expected=" + expected2 + " | actual=" + result2);
        }

        Remote quietTv = new QuietRemote("R3", new TvDevice());
        String result3 = quietTv.execute();
        String expected3 = "TV | power=ON | volume=5";
        if (result3.equals(expected3)) {
            passed++;
            System.out.println("T3 PASS | QuietRemote + TvDevice | result=" + result3);
        } else {
            System.out.println("T3 FAIL | expected=" + expected3 + " | actual=" + result3);
        }

        Remote quietRadio = new QuietRemote("R4", new RadioDevice());
        String result4 = quietRadio.execute();
        String expected4 = "RADIO | power=ON | volume=5";
        if (result4.equals(expected4)) {
            passed++;
            System.out.println("T4 PASS | QuietRemote + RadioDevice | result=" + result4);
        } else {
            System.out.println("T4 FAIL | expected=" + expected4 + " | actual=" + result4);
        }

        Remote remote = new BasicRemote("R5", new TvDevice());
        Remote originalReference = remote;

        String idBefore = remote.getId();
        String before = remote.execute();

        remote.setImplementation(new RadioDevice());

        String after = remote.execute();

        boolean sameObject = originalReference == remote;
        boolean stateUnchanged = idBefore.equals(remote.getId());
        boolean correctSwitch =
                before.equals("TV | power=ON | volume=30") && after.equals("RADIO | power=ON | volume=30");

        if (sameObject && stateUnchanged && correctSwitch) {
            passed++;
            System.out.println("T5 PASS | sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged);
            System.out.println(" before=" + before + " | after=" + after);
        } else {
            System.out.println("T5 FAIL | sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged);
        }

        Remote basicProjector = new BasicRemote("R6", new ProjectorDevice());
        String result6 = basicProjector.execute();
        String expected6 = "PROJECTOR | power=ON | volume=30";

        if (result6.equals(expected6)) {
            passed++;
            System.out.println("T6 PASS | BasicRemote + ProjectorDevice | result=" + result6);
        } else {
            System.out.println("T6 FAIL | expected=" + expected6 + " | actual=" + result6);
        }

        Remote quietProjector = new QuietRemote("R7", new ProjectorDevice());
        String result7 = quietProjector.execute();
        String expected7 = "PROJECTOR | power=ON | volume=5";

        if (result7.equals(expected7)) {
            passed++;
            System.out.println("T7 PASS | QuietRemote + ProjectorDevice | result=" + result7);
        } else {
            System.out.println("T7 FAIL | expected=" + expected7 + " | actual=" + result7);
        }

        System.out.println("SUMMARY: " + passed + "/7 PASS");
    }
}