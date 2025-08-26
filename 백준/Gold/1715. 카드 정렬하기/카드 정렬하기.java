import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> q = new PriorityQueue<>();
    
    int result = 0;
    
    for(int i = 0 ; i < N ; i++){
      q.add(Integer.parseInt(br.readLine()));
    }
    
    while(q.size() != 1) {
      int a = q.poll();
      int b = q.poll();
      
      q.add(a+b);
      
      result += a+b;
    }
    
    System.out.print(result);
  }
}