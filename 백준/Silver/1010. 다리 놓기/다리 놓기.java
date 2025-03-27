import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger[] arr = new BigInteger[30];
        arr[0] = BigInteger.ONE;
        
        for(int i = 1 ; i < 30 ; i++){
            arr[i] = BigInteger.valueOf(i).multiply(arr[i-1]);
        }
        
        int N = sc.nextInt();
        
        for(int i = 0 ; i < N ; i++){
            int b = sc.nextInt();
            int a = sc.nextInt();
            System.out.println(arr[a].divide(arr[a-b].multiply(arr[b])));
        }
    }
}