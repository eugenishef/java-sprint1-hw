public class Converter {
    public static int convertToKm(int steps) {
        int distanceInCm = steps * 75;
        int distanceInKm = distanceInCm / 100000;

        return distanceInKm;
    }

    public static int convertStepsToKilocalories(int steps) {
        int kilocalories = steps * 50 / 1000;

        return kilocalories;
    }
}
