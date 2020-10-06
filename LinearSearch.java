public class LinearSearch extends RunTime implements SearchInterface {

    /**
     * Searches a target value in an array representing a listOfNumbers
     * Returns index if target is found
     * Otherwise returns -1
     */


    @Override
    public int search(int[] listOfNumbers, int target) {
        for (int i = 0; i < listOfNumbers.length; i++) {
            if (listOfNumbers[i] == target)   // If target is found return i
                return i;
        }

        return -1;
    }
}
