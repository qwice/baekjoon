import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] arr = new int[2];
		
		int n = Integer.parseInt(br.readLine());
	  for(int i = 0 ; i < n ; i++){
	    st = new StringTokenizer(br.readLine());
	    arr[0] = Integer.parseInt(st.nextToken());
	    arr[1] = Integer.parseInt(st.nextToken());
	    System.out.println(min(arr[0], arr[1]));
	  }
	}
	
	public static int min(int a, int b){
	  int max = Math.max(a, b);
	  for(int i = 1 ; ; i++){
	    if(max * i % a == 0 && max * i % b == 0) return max * i;
	  }
	}
}
