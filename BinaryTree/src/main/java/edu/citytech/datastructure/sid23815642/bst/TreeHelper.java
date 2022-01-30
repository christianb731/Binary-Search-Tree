package edu.citytech.datastructure.sid23815642.bst;

public class TreeHelper {
    public static boolean isEmpty(Object value){
        if (value == null){
            return true;
    }
    return false;
    }
    public static <T extends Comparable<T>> boolean isLessThan(T value1, T value2){
        int status = value1.compareTo(value2);
        return status < 0;
    }
    public static <T extends Comparable<T>> boolean isGreaterThan(T value1, T value2){
        int status = value1.compareTo(value2);
        return status > 0;
    }
    public static <T extends Comparable<T>> boolean isEqual(T value1, T value2){
        int status = value1.compareTo(value2);
        return status == 0;
    }
}
