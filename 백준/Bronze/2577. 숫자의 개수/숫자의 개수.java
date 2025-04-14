import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        int[] arr = new int[10];
        int temp = A * B * C;
        
        while(temp > 0){
            arr[temp % 10]++;
            temp /= 10;
        }
        
        for(int i = 0 ; i < 10 ; i++){
            System.out.println(arr[i]);
        }
    }
}