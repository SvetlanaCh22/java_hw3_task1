// Реализовать алгоритм сортировки слиянием

// Чубченко Светлана

import java.util.Arrays;

public class main {

    public static void main(String args[]) {
        // массив для сортировки
        int[] unsortedArr = {345, 23, 545, 69, 231, 11, 435, 67, 32};
        // отсортированный массив
        int[] sortedArr = Sort(unsortedArr);
        // выводим результат
        System.out.println(Arrays.toString(sortedArr));
    }

    public static int[] Sort(int[] unsortedArr) {
        // создаем два буфера: оригинал и для сортировки
        int[] buffer1 = Arrays.copyOf(unsortedArr, unsortedArr.length);
        int[] buffer2 = new int[unsortedArr.length];
        // сортируем
        int[] result = mergeSortInner(buffer1, buffer2, 0, unsortedArr.length);
        return result;
    }

    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        // если конец массива - завешршим рекурсию
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        // производим слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}
