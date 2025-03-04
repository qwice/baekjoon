import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());;
		String[] arr = new String[2];
		Map<String, String> map1 = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
	
		for(int i = 1 ; i <= n ; i++){
		    st = new StringTokenizer(br.readLine());
		    String key = st.nextToken();
		    map1.put(String.valueOf(i), key);
		    map2.put(key, String.valueOf(i));
		}
		
		for(int i = 0 ; i < m ; i++){
		  st = new StringTokenizer(br.readLine());
		  String key = st.nextToken();
		  if (key.matches("\\d+")) {
		    System.out.println(map1.get(key));
		  } else {
		    System.out.println(map2.get(key));
		  }
		}
		
	}
}
