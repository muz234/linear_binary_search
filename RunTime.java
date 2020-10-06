import java.util.Arrays;

/**
 * This interface is used to organize and manage runtimes
 * measured for specific operations
 */
/*
    public interface RuntimeInterface {

        public void addRuntime(long runTime);   // Adds a runtime
        public double getAverageRunTime();   // Obtain the average runtime
        public long getLastRunTime();   // Retrieve the last runtime
        public long[] getRunTimes();   // Returns an array of long values representing the last 10 runtimes
        public void resetRunTimes();   // Reset all 10 linear search times to zero
    }

    public interface SearchInterface {

        public int search(int[] listOfNumbers, int target);   // Searches a target value in an array representing a listOfNumbers
    }

    public interface DriverInterface {

        public int[] getListOfNumbers();   // Generate and return a sorted array of int values starting at 1 and ending at 10,000,000
        public int[] getTargets();   // Returns an int array containing values 500, 10000, 100000, 1000000, 5000000, 7500000, 10000000
        public RunTime runBinarySearch(int[] listOfNumbers, int target, int numberOfTimes);   // Creates an instance of BinarySearch.java class and runs the search for the specified target in the listOfNumbers a total of numberOfTimes
        public RunTime runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes);   // Creates an instance of LinearSearch.java class and runs the search for the specified target in the listOfNumbers a total of numberOfTimes
    }
   */

    public class RunTime implements TestTimesInterface {

        private static final int MAX = 10;

        // Instance variables
        private long[] runtimes;
        private int count;

        /**
         * Constructor
         */


        public RunTime() {
            this.runtimes = new long[MAX];
            this.count += 0;
        }

        /**
         * Adds a runtime
         */


        @Override
        public void addRuntime(long runTime) {
            if (this.count == MAX) {
                // If total runtimes is MAX, shift all runtimes 1 position up
                for (int i = 0; i < (MAX - 1); i++) {
                    this.runtimes[i] = this.runtimes[i + 1];
                }
                // Add the new runtime at MAX - 1
                this.runtimes[MAX - 1] = runTime;
            } else {
                // Add the new runtime
                this.runtimes[count] = runTime;
                // Increment count
                this.count += 1;
            }
        }

        /**
         * Obtain the average runtime
         */


        @Override
        public double getAverageRunTime() {
            double sum = 0;
            for (int i = 0; i < this.count; i++) {
                sum += this.runtimes[i];
            }

            return (sum / this.count);
        }

        /**
         * Retrieve the last runtime
         */


        @Override
        public long getLastRunTime() {
            return this.runtimes[this.count - 1];
        }

        /**
         * Returns an array of long values representing the last 10 runtimes
         */

        @Override
        public long[] getRunTimes() {
            return Arrays.copyOf(this.runtimes, this.count);
        }

        /**
         * Reset all 10 linear search times to zero
         */


        @Override
        public void resetRunTimes() {
            for (int i = 0; i < MAX; i++) {
                this.runtimes[i] = 0;
            }
        }

        @Override
        public long getLastTestTime() {
            return 0;
        }

        @Override
        public long[] getTestTimes() {
            return new long[0];
        }

        @Override
        public void resetTestTimes() {

        }

        @Override
        public void addTestTime(long testTime) {

        }

        @Override
        public double getAverageTestTime() {
            return 0;
        }
    }

    class Driver implements DriverInterface {

        /**
         * Generate and return a sorted array of int values starting at 1 and ending
         * at 10,000,000
         */

        @Override
        public int[] getListOfNumbers() {
            int[] arr = new int[10000000];
            for (int i = 0; i < 10000000; i++) {
                arr[i] = i + 1;
            }
            return arr;
        }

        /**
         * Returns an int array containing values 500, 10000, 100000, 1000000,
         * 5000000, 7500000, 10000000
         */

        @Override
        public int[] getTargets() {
            int[] arr = { 500, 10000, 100000, 1000000, 5000000, 7500000, 10000000 };

            return arr;
        }

        /**
         * Creates an instance of BinarySearch.java class and runs the search for
         * the specified target in the listOfNumbers a total of numberOfTimes
         */

        @Override
        public RunTime runBinarySearch(int[] listOfNumbers, int target, int numberOfTimes) {
            // Create BinarySearch object
            BinarySearch search = new BinarySearch();
            // Start search
            for (int i = 0; i < numberOfTimes; i++) {
                long startTime = System.nanoTime(); // Get start time
                System.out.println("Found " + target + " at " + search.search(listOfNumbers, target));
                long endTime = System.nanoTime(); // Get end time

                // Add runtime
                search.addRuntime(endTime - startTime);
            }

            return search;
        }

        /**
         * Creates an instance of LinearSearch.java class and runs the search for
         * the specified target in the listOfNumbers a total of numberOfTimes
         */
        @Override


        public RunTime runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes) {
            // Create LinearSearch object
            LinearSearch search = new LinearSearch();
            // Start search
            for (int i = 0; i < numberOfTimes; i++) {
                long startTime = System.nanoTime(); // Get start time
                System.out.println("Found " + target + " at " + search.search(listOfNumbers, target));
                long endTime = System.nanoTime(); // Get end time

                // Add runtime
                search.addRuntime(endTime - startTime);
            }

            return search;
        }


        public static void main(String[] args) {

            // Create a Driver object
            Driver driver = new Driver();
            int[] listOfNumbers = driver.getListOfNumbers();
            int[] targets = driver.getTargets();
            int numberOfTimes = 2;

            for (int target : targets) {
                System.out.println("Searching for " + target);
                System.out.println("BinarySearch....");
                // Get runtimes
                RunTime r = driver.runBinarySearch(listOfNumbers, target, numberOfTimes);
                System.out.println("Displaying runtimes");
                long[] runtimes = r.getRunTimes();
                for (int i = 0; i < runtimes.length; i++) {
                    System.out.println("Runtime " + (i + 1) + " - " + runtimes[i]);
                }

                System.out.println("\nLinearSearch....");
                // Get runtimes
                r = driver.runLinearSearch(listOfNumbers, target, numberOfTimes);
                System.out.println("Displaying runtimes");
                runtimes = r.getRunTimes();
                for (int i = 0; i < runtimes.length; i++) {
                    System.out.println("Runtime " + (i + 1) + " - " + runtimes[i]);
                }

                System.out.println("\n----------------------\n");
            }

        }
    }


