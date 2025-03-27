import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] fac = new int[N + 1];
        fac[0] = 1;
        fac[1] = 1;
        for(int i = 2 ; i <= N ; i++){
            fac[i] = i * fac[i-1];
        }
        
        System.out.print(fac[N] / fac[N-K] / fac[K]);
    }
}