public class BinarySearch {
    public static void main (String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Binary_Search(arr, 4));
    }

    public static int Binary_Search (int[] arr, int val) {
        int l = 0, r = arr.length-1;
        while (l < r) {
            int mid = (l+r)/2;
            if (arr[mid] == val) {
                return (mid+1);
            } else if (arr[mid] > val) {
                r = mid;
            } else if (arr[mid] < val) {
                l = mid;
            }
        }
        return -1;
    }
}
