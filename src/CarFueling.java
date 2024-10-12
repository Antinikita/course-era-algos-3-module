import java.util.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int numRefills = 0;
        int currentPosition = 0;
        int n = stops.length;

        // Add start (0) and destination (d) to the stops array
        int[] allStops = new int[n + 2];
        allStops[0] = 0;
        System.arraycopy(stops, 0, allStops, 1, n);
        allStops[n + 1] = dist;

        while (currentPosition < n + 1) {
            int lastPosition = currentPosition;

            // Move as far as possible with the current fuel
            while (currentPosition < n + 1 && allStops[currentPosition + 1] - allStops[lastPosition] <= tank) {
                currentPosition++;
            }

            // If no progress is made, it's impossible to reach the destination
            if (currentPosition == lastPosition) {
                return -1;
            }

            // If we haven't reached the destination, we need to refuel
            if (currentPosition < n + 1) {
                numRefills++;
            }
        }

        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n+1];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }
        stops[n]=dist;
        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
