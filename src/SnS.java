public class SnS { //sorts and searches
    
    private int[] arr;

    public SnS(){
        arr = new int[12];
        for (int i = 0; i < arr.length; i++) {
            int tempInt = (int) (Math.random() * 100);
            boolean repeating = false;
            for (int num : arr) { //had a problem with it generating duplicates
                if (tempInt == num) {
                    repeating = true;
                    break;
                }
            }
            if (!repeating) {
                arr[i] = tempInt;
            } else {
                i--; 
            }
        }
    }

    public int[] getArr() {
        return arr;
    }

    //bubble sort
    public int[] bubbleSort(){
        int [] tempArr = arr.clone(); 
        for (int i = 0; i < tempArr.length - 1; i++) { //every element
            for (int j = 0; j < tempArr.length - i - 1; j++) { //cutoff at the endd due to it sequentially finding the largest element and moving it right
                if (tempArr[j] > tempArr[j + 1]) {
                    int temp = tempArr[j];
                    tempArr[j] = tempArr[j + 1];
                    tempArr[j + 1] = temp;
                }
            }
        }
        return tempArr;
    }


    //merge sort infrastructure
    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; //length of left side of the array
        int n2 = right - mid; //length of right side of the array

        int[] L = new int[n1]; //initialise both arrays needed for split
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) { //split
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) { //goes through both arrays and compares them. Iterating if they have the lowest value, while adding that to the new array that stores the sorted numbers
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // section that inserts last few numbers left in the arrays.
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            }
        }

    private void mergeSplit(int[] arr, int left, int right) { //initial array, leftmost index, rightmost index
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSplit(arr, left, mid); //recursion, splitting leftside array
            mergeSplit(arr, mid + 1, right); //recursion, splitting rightside array
            merge(arr, left, mid, right);
        }
    }

    //actual merge sort
    public int[] mergeSort(){
        int[] tempArr = arr.clone(); //do not want original modified
        mergeSplit(tempArr, 0, tempArr.length - 1);
        return tempArr;
    }

    //linear search
    public int linearSearch(int t){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == t) {
                return i;
            }
        }
        return -1;
    }

    public String searchToString(int t){
        if (t != -1) {
            return "Element found at index: " + t;
        } else {
            return "Element not found";
        }
    }

    //binary search
    public int binarySearch(int[] tempArr, int t){
        int left = 0;
        int right = tempArr.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (tempArr[mid] == t) {
                return mid;
            }
            if (tempArr[mid] > t) {
                right = mid - 1;
            }
            if (tempArr[mid] < t) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
