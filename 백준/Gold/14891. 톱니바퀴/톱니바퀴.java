import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer>[] gears = (Deque<Integer>[])new LinkedList[4];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i = 0 ; i < 4 ; i++){
          gears[i] = new LinkedList<>();
          String line = br.readLine();
          for (char ch : line.toCharArray()) {
              gears[i].add(ch - '0');
          }
        }
        
        int K = Integer.parseInt(br.readLine());
        
        for(int k = 0 ; k < K ; k++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          int num = Integer.parseInt(st.nextToken()) - 1;
          int dir = Integer.parseInt(st.nextToken());
          int[] rotate = new int[4];
          
          rotate[num] = dir;
          
          for(int i = num - 1; i >=0 ; i--){
            int right = ((LinkedList<Integer>)gears[i + 1]).get(6);
            int left = ((LinkedList<Integer>)gears[i]).get(2);
            if(right != left) rotate[i] = -rotate[i + 1];
            else break;
          }
          
          for(int i = num + 1 ; i < 4; i++){
            int right = ((LinkedList<Integer>)gears[i]).get(6);
            int left = ((LinkedList<Integer>)gears[i - 1]).get(2);
            if(right != left) rotate[i] = -rotate[i - 1];
            else break;
          }
          
          for(int i = 0 ; i < 4 ; i++){
            if(rotate[i] == 1){
              rotateClock(gears[i]);
            } else if(rotate[i] == -1){
              InverseRotate(gears[i]);
            }
          }
        }
        
        int score = 0;
        for(int i = 0 ; i < 4 ; i++){
          score += gears[i].peekFirst() * Math.pow(2, i);
        }
          
        System.out.print(score);
    }
    
    static void rotateClock(Deque<Integer> gear){
      gear.addFirst(gear.pollLast());
    }
    
    static void InverseRotate(Deque<Integer> gear){
      gear.addLast(gear.pollFirst());
    }
}
