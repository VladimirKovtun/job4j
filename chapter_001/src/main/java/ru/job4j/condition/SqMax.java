package ru.job4j.condition;

public class SqMax {

    public static int max(int first, int second, int third, int forth){
        int result = forth;
        if (first > second){
            result = first > third ? (first > forth ? first : result) : third;
        }else if (second > third){
                  if (second > forth){
                      result = second;
                  }
        }else if (third > forth){
                  result = third;
        }
        return result;
    }
}
