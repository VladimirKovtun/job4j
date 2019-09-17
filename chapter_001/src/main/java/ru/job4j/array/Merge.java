package ru.job4j.array;


public class Merge {

    public static int[] merge(int[] firstArray, int[] secondArray) {
        int firstIndex = 0;
        int secondIndex = 0;
        int[] resultArray = new int[firstArray.length + secondArray.length];

        for (int i = 0; i < resultArray.length; i++) {
            if (firstIndex < firstArray.length) {
                resultArray[i] = firstArray[firstIndex];
                firstIndex++;
            } else if (secondIndex < secondArray.length) {
                resultArray[i] = secondArray[secondIndex];
                secondIndex++;
            }
        }
        return resultArray;
    }
}
