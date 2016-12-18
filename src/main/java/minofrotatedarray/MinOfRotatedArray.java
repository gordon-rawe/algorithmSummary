package minofrotatedarray;

/**
 * Created by gordon on 16/12/10.
 */
public class MinOfRotatedArray {
    public static int minOfRoratedArray(int[] array) throws Exception {
        if (array == null || array.length <= 0) throw new Exception("invalid array input");
        int len = array.length;
        int leftIndex = 0, rightIndex = len - 1, midIndex = leftIndex;
        while (array[leftIndex] >= array[rightIndex]) {
            if (rightIndex - leftIndex == 1) {
                midIndex = rightIndex;
                break;
            }
            midIndex = (leftIndex + rightIndex) / 2;
            if(array[midIndex] == array[leftIndex] && array[midIndex] == array[rightIndex]) return minInOrderTraverse(array,leftIndex,rightIndex);
            if (array[midIndex] >= array[leftIndex]) leftIndex = midIndex;
            else if (array[midIndex] <= array[rightIndex]) rightIndex = midIndex;
        }
        return array[midIndex];
    }

    public static int minInOrderTraverse(int[] array, int start, int end) {
        int result = array[start];
        for (int i = start + 1; i <= end; i++) {
            if(result > array[i]) result = array[i];
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
