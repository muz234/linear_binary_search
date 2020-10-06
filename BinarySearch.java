public class BinarySearch extends RunTime implements SearchInterface {

    /**
     * Searches a target value in an array representing a listOfNumbers
     */


    @Override
    public int search(int[] listOfNumbers, int target) {
        int start = 0;
        int end = listOfNumbers.length - 1;
        int mid;
        do {
            mid = ((end - start) / 2) + start;
            if (target > listOfNumbers[mid]) {
                start = mid + 1;

            } else if (target < listOfNumbers[mid]) {
                end = mid - 1;

            } else {   // If match is found
                return mid;
            }
        } while (start <= end);

        return -1;
    }
}
