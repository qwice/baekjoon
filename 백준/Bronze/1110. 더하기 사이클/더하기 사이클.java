import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int n = N;;
        int count = 0;
        while(true){
            count++;
            int F = 0, L = 0;
            F = n / 10;
            L = n % 10;
            n = L * 10 + (F + L) % 10;
            if(n == N) break;
        }
        System.out.print(count);
    }
}