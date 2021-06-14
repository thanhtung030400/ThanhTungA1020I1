package b13.binary_search.thuc_hanh.binary_search;

public class BinarySearch {
    static int[] list =  {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
    static int binarySearch (int [] list, int key) {
        int low = 0;
        int high = list.length - 1;
        int mid = 0;
        while (high >= low) {
            mid = (high + low) /2;
            if (key < list[mid]){
                high = mid - 1;
            }else if (key == list[mid]){
                return mid;
            }else
                low= mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(list,2));
    }
}
