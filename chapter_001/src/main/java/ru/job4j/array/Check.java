package ru.job4j.array;

public class Check {

    public boolean mono(boolean[] data){
        boolean result = true;
        boolean el = data[0];
        for (int i = 0; i < data.length; i++){
            if (data[i] != el){
                result = false;
                break;
            }
        }
        return result;
    }
}
