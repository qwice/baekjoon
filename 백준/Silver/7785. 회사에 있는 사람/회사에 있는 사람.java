import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] arr = new String[2];
		Map<String, String> map = new HashMap<>();
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < n ; i++){
		    st = new StringTokenizer(br.readLine());
		    arr[0] = st.nextToken();
		    arr[1] = st.nextToken();
		    if(arr[1].equals("enter")) map.put(arr[0], arr[0]);
		    else map.remove(arr[0]);
		}
		
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list, Collections.reverseOrder());
		for(String key : list){
		    System.out.println(key);
		}
	}
}
