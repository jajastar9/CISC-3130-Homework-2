public class Runner{
    public static void main(String[] args) {
        SnS sorters = new SnS();
        int[] bubbleSortedArr = sorters.bubbleSort(); //differentiating these arrays
        int[] mergeSortedArr = sorters.mergeSort();
        System.out.println("Unsorted array: " + java.util.Arrays.toString(sorters.getArr()));
        System.out.println("Bubble sorted array: " + java.util.Arrays.toString(bubbleSortedArr));
        System.out.println("Merge sorted array: " + java.util.Arrays.toString(mergeSortedArr));
        //setup for linear search
        int randomElementFrontL = sorters.getArr()[(int) (Math.random() * (sorters.getArr().length / 2))];
        int randomElementBackL = sorters.getArr()[(int) (Math.random() * (sorters.getArr().length / 2)) + (sorters.getArr().length / 2)];
        //setup for binary search
        int randomElementFrontB = mergeSortedArr[(int) (Math.random() * (mergeSortedArr.length / 2))];
        int randomElementBackB = mergeSortedArr[(int) (Math.random() * (mergeSortedArr.length / 2)) + (mergeSortedArr.length / 2)];
        //linear search (front, back, DNE)
        System.out.println("Linear search result for " + randomElementFrontL + " (front). " + sorters.searchToString(sorters.linearSearch(randomElementFrontL)));
        System.out.println("Linear search result for " + randomElementBackL + " (back). " + sorters.searchToString(sorters.linearSearch(randomElementBackL)));
        System.out.println("Linear search result for 1000 (out of bounds): " + sorters.searchToString(sorters.linearSearch(1000)));
        //binary search (front, back, DNE)
        System.out.println("Binary search result for " + randomElementFrontB + " (front). " + sorters.searchToString(sorters.binarySearch(mergeSortedArr, randomElementFrontB)));
        System.out.println("Binary search result for " + randomElementBackB + " (back). " + sorters.searchToString(sorters.binarySearch(mergeSortedArr, randomElementBackB)));
        System.out.println("Binary search result for 1000 (out of bounds): " + sorters.searchToString(sorters.binarySearch(mergeSortedArr, 1000)));
    }
}