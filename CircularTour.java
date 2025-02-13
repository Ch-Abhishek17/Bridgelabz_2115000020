/*
 Circular Tour Problem
Problem: Given a set of petrol pumps with petrol and distance to the next pump, determine the starting point for completing a circular tour.
Hint: Use a queue to simulate the tour, keeping track of surplus petrol at each pump.
 */
class CircularTour {
    public static int findStartingPump(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalSurplus = 0, currentSurplus = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int netPetrol = petrol[i] - distance[i];
            totalSurplus += netPetrol;
            currentSurplus += netPetrol;

            // If deficit occurs, reset start index to next pump
            if (currentSurplus < 0) {
                start = i + 1;
                currentSurplus = 0;
            }
        }

        return (totalSurplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        
        int startPump = findStartingPump(petrol, distance);
        System.out.println("Start from petrol pump: " + startPump);
    }
}
