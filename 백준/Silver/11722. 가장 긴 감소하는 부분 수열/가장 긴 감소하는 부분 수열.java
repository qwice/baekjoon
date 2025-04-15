import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] minus = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < n ; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = n-1 ; i >= 0 ; i--){
            minus[i] = 1;
            for(int j = n-1 ; j >= i ; j--){
                if(num[j] < num[i] && minus[i] < minus[j] + 1){
                    minus[i] = minus[j] + 1;
                }
            }
        }
        
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max, minus[i]);
        }
        
        System.out.print(max);
    }
}