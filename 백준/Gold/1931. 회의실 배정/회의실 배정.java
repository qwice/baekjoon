import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        List<int[]> meetings = new ArrayList<>();
        
        for(int i = 0 ; i < N ; i++){
          st = new StringTokenizer(br.readLine());
          int start = Integer.parseInt(st.nextToken());
          int end = Integer.parseInt(st.nextToken());
          
          meetings.add(new int[]{start, end});
        }
        
        meetings.sort((a,b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        int count = 0;
        int endTime = 0;
        
        for(int[] arr : meetings){
          if(arr[0] >= endTime){
            count++;
            endTime = arr[1];
          }
        }
        
        System.out.print(count);
    }
}
