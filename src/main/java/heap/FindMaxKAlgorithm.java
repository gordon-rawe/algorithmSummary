package heap;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by gordon on 16/9/16.
 */
public class FindMaxKAlgorithm {

    private int[] numbers;
    private int[] originalNumbers;

    private FindMaxKAlgorithm(int[] numbers) {
        this.numbers = numbers;
        this.originalNumbers = Arrays.copyOf(numbers, numbers.length);
    }

    private int[] getOriginalNumbers() {
        return originalNumbers;
    }

    private void swap(int from, int to) {
        if (from > numbers.length - 1 || to > numbers.length - 1)
            throw new IndexOutOfBoundsException("index out of number array");
        int tmpValue = numbers[from];
        numbers[from] = numbers[to];
        numbers[to] = tmpValue;
    }

    private void maxHeapify(int curSize, int index) {//curSize是用来设置交换停止条件
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int larger = index;
        if (left < curSize && numbers[larger] < numbers[left]) larger = left;
        if (right < curSize && numbers[larger] < numbers[right]) larger = right;
        if (larger != index) {
            swap(larger, index);
            maxHeapify(curSize, larger);//交换了一个以后，不确定它后面的是否满足，所以需要递归一下
        }
    }

    private void buildMaxHeap() {
        int count = numbers.length;//后面的元素其实都不需要建堆，因为他们都没有三个元素不会执行
        for (int i = count / 2; i >= 0; i--) {
            maxHeapify(count, i);
        }
    }

    private void heapSort() {
        int heapSize = numbers.length;
        buildMaxHeap();
        for (int i = numbers.length - 1; i > 0; i--) {
            swap(i, 0);
            heapSize--;
            maxHeapify(heapSize, 0);
        }
    }

    public static void swap(int[] source, int from, int to) {
        int tmpValue = source[from];
        source[from] = source[to];
        source[to] = tmpValue;
    }

    public static void heapify(int[] source, int curSize, int index) {
        int left = 2 * index + 1, right = 2 * index + 2;
        int larger = index;
        if (left < curSize && source[larger] < source[left]) larger = left;
        if (right < curSize && source[larger] < source[right]) larger = right;
        if (larger != index) {
            swap(source, larger, index);
            heapify(source, curSize, larger);
        }
    }

    public static void buildMaxHeap(int[] source) {
        for (int i = source.length / 2; i >= 0; i--) {
            heapify(source, source.length, i);
        }
    }

    public static int[] getLastK(int[] source, int k) {
        if (k < 1 || source.length < k) return null;
        int[] ret = new int[k];
        int curSize = source.length - 1;
        buildMaxHeap(source);
        for (int i = 0; i < k; i++) {
            swap(source, 0, curSize);
            ret[i] = source[curSize];
            curSize--;
            heapify(source, curSize, 0);

        }
        return ret;
    }

    private int[] getSortedNumbers() {
        heapSort();
        return numbers;
    }

    public int[] getMaxKNumbers(int k) {
        int[] retValue = new int[k];
        int pointer = 0;
        if (k > numbers.length) throw new IndexOutOfBoundsException();
        int validHeapSize = numbers.length;
        buildMaxHeap();
        for (int i = numbers.length - 1; i > numbers.length - k - 1; i--) {
            retValue[pointer++] = numbers[0];
            swap(0, i);
            validHeapSize--;
            maxHeapify(validHeapSize, 0);

        }
        return retValue;
    }

    public static int[] generateRandomNumbers() {
        Random seed = new Random();
        int[] retValue = new int[seed.nextInt(100)];
        for (int i = 0; i < retValue.length; i++) {
            retValue[i] = seed.nextInt(1000);
        }
        return retValue;
    }

    public static void main(String[] args) {
//        FindMaxKAlgorithm algorithm = new FindMaxKAlgorithm(FindMaxKAlgorithm.generateRandomNumbers());
//        System.out.println("original numbers:");
//        Arrays.stream(algorithm.getOriginalNumbers()).forEach(System.out::println);
//        System.out.println("sorted numbers:");
//        Arrays.stream(algorithm.getSortedNumbers()).forEach(System.out::println);
//        System.out.println("max numbers:");
//        Arrays.stream(algorithm.getMaxKNumbers(4)).forEach(System.out::println);
        int[] source = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        for (int i : getLastK(source, 3)) {
            System.out.println(i);
        }

    }
}
