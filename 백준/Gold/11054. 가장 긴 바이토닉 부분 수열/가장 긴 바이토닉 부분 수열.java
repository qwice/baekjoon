import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] num = new int[N];
        int[] plus = new int[N];
        int[] minus = new int[N];
        
        for(int i = 0 ; i < N ; i++){
          num[i] = sc.nextInt();
        }
        
        for(int i = 0 ; i < N ; i++){
          plus[i] = 1;
          for(int j = 0 ; j < i ; j++){
            if(num[j] < num[i] && plus[i] < plus[j] + 1){
              plus[i] = plus[j] + 1;
            }
          }
        }
        
        for(int i = N-1; i >= 0; i--){
          minus[i] = 1;
          for(int j = N-1 ; j > i; j--){
            if(num[j] < num[i] && minus[i] < minus[j] + 1){
              minus[i] = minus[j] + 1;
            }
          }
        }
        
        int max = 0;
        for(int i = 0 ; i < N ; i++){
          max = Math.max(max, plus[i] + minus[i] - 1);
        }
        
        System.out.print(max);
    }
}
