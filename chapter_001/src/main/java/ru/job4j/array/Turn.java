package ru.job4j.array;

public class Turn {

    public int[] back(int[] array){
        int index = array.length;
        for (int i = 0; i < (index/2); i++){
            int temp = array[i];
            array[i] = array[index - 1 - i];
            array[index - 1  - i] = temp;
        }
        return array;
    }
}
