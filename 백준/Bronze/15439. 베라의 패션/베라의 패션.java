import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        
        if(N == 1) ans = 0;
        else ans = N * (N-1);
        System.out.print(ans);
    }
}