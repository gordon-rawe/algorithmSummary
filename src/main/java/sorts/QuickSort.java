package sorts;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by gordon on 9/27/16.
 */
public class QuickSort {

    public static int[] buildArrayNumbers() {
        Random random = new Random();
        int length = 50 + random.nextInt(50);
        int[] retValue = new int[length];
        for (int i = 0; i < length; i++) {
            retValue[i] = random.nextInt(500);
        }
        return retValue;
    }

    public static void swap(int[] src, int from, int to) {
        int tmp = src[from];
        src[from] = src[to];
        src[to] = tmp;
    }

    public static int partition(int[] source, int low, int high) {
        int value = source[low];
        while (low < high) {
            while (low < high && source[high] >= value) high--;
            swap(source, low, high);
            while (low < high && source[low] <= value) low++;
            swap(source, low, high);
        }
        return low;
    }

    public static int partition1(int[] source, int low, int high) {
        int value = source[low];
        while (low < high) {
            while (low < high && source[high] > value) high--;
            source[low] = source[high];
            while (low < high && source[low] <= value) low++;
            source[high] = source[low];
        }
        source[low] = value;
        return low;
    }

    public static int checkMoreThanHalf(int[] src) {
        if (src == null || src.length == 0) return -1;
        int start = 0, end = src.length - 1, midIndex = src.length >> 1;
        int index = partition1(src, start, end);
        while (midIndex != index) {
            if (index > midIndex){
                end = index-1;
                index = partition1(src,start,end);
            }else {
                start = index+1;
                index = partition1(src,start,end);
            }
        }
        int result = src[midIndex];
        int times = 0;
        for (int i = 0; i < src.length; i++) {
            if(src[i] == result)times++;
        }
        if(times*2 <= src.length)return -1;
        return result;
    }

    public static int checkMoreThanHalf1(int[] src) {
        if(src==null || src.length == 0)return -1;
        int count = 1;
        int watcher = src[0];
        for (int i = 1; i < src.length; i++) {
            if(count==0){
                count =1;
                watcher = src[i];
            }else if(watcher == src[i]){
                count++;
            }else {
                count--;
            }
        }
        int result = watcher;
        int times = 0;
        for (int i = 0; i < src.length; i++) {
            if(src[i] == result)times++;
        }
        if(times*2 <= src.length)return -1;
        return result;
    }

    public static int[] getMaxK(int[] source, int k) {
        if (k < 1 || source == null || source.length < k) return null;
        int[] ret = new int[k];
        int start = 0, end = source.length - 1;
        int index = partition1(source, start, end);
        while (index != k - 1) {
            if (index > k - 1) {/**往左继续*/
                end = index - 1;
                index = partition1(source, start, end);
            } else {
                start = index + 1;
                index = partition1(source, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            ret[i] = source[i];
        }
        return ret;
    }



    public static void quickSort(int[] source, int low, int high) {
        if (low < high) {
            int pivot = partition(source, low, high);
            quickSort(source, low, pivot - 1);
            quickSort(source, pivot + 1, high);
        }
    }

//
//    public static int partition(int[] src, int low, int high) {
//        int value = src[low];
//        while (low < high) {
//            while (low < high && src[high] >= value) high--;
//            swap(src, low, high);
//            while (src[low] < value && low < high) low++;
//            swap(src, low, high);
//        }
//        return low;
//    }
//
//    public static void quickSort(int[] source, int low, int high) {
//        if (low < high) {
//            int pivot = partition(source, low, high);
//            quickSort(source, low, pivot - 1);
//            quickSort(source, pivot + 1, high);
//        }
//    }


    public static void main(String[] args) {
        int[] source = buildArrayNumbers();
        quickSort(source, 0, source.length - 1);
        Arrays.stream(source).forEach(System.out::println);
    }
}