// Week2
// you are given an array which includes product of subset of array any array 'S' of length l, 
// Find element of an array S 
// of length L.
// l=3, a [] = {10,10,5,0,2,1,2,5}
// a [] = {2,1,5} will be able to output provided subset product.
// Explanation:
// [] product [0]
// [1] product [1]
// [2] product [2]
// [5] product [5]
// [1,2] product [2]
// [1,5] product [5]
// [2,5] product [10]
// [1,2,5] product [10]



import java.util.Arrays;

public class week2 {
    public static<Demo> Demo[] Array_Subset(Demo[] Array, int Begin_Index, int End_Index) {
        return Arrays.copyOfRange(Array, Begin_Index, End_Index);
    }

    public static void main(String[] args) {
        String[] Demo_Array = {"10", "10", "5",
                "0", "2", "1","5" };
        int Begin_Index = 4;
        int End_Index = 7;

        String[] Subset = Array_Subset(Demo_Array, Begin_Index, End_Index);
        System.out.println(Arrays.toString(Subset));
    }
}