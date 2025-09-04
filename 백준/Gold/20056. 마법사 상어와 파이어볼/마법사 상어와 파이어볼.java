import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static Map<String, List<Info>> list = new HashMap<>();
	static Map<String, List<Info>> Alist = new HashMap<>();
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			String point = r + "," + c;
			
			List<Info> val = list.getOrDefault(point, new ArrayList<>());
			val.add(new Info(m, s, d));
			
			list.put(point, val);
		}
		
		while(K-- > 0) {
			for(String p : list.keySet()) {
				List<Info> val = list.get(p);
				String[] point = p.split(",");
				int r = Integer.parseInt(point[0]);
				int c = Integer.parseInt(point[1]);
				
				for(Info f : val) {
					int nr = (((r + f.s * dx[f.d]) % N) + N) % N;
					int nc = (((c + f.s * dy[f.d]) % N) + N) % N;
					
					String np = nr + "," + nc;
					
					List<Info> nval = Alist.getOrDefault(np, new ArrayList<>());
					nval.add(new Info(f.m, f.s, f.d));
					
					Alist.put(np, nval);
				}
			}
			
			list = new HashMap<>(Alist);
			Alist.clear();
			
			for(String p : list.keySet()) {
				List<Info> val = list.get(p);
				
				if(val.size() >= 2) {
					int totalm = 0;
					int totals = 0;
					Set<Integer> set = new HashSet<>();
					
					for(Info f : val) {
						totalm += f.m;
						totals += f.s;
						
						set.add(f.d % 2);
					}
					
					totalm /= 5;
					totals /= val.size();
					
					if(totalm == 0) continue;
					
					if(set.size() == 1) {
						List<Info> nval = new ArrayList<>();
						nval.add(new Info(totalm, totals, 0));
						nval.add(new Info(totalm, totals, 2));
						nval.add(new Info(totalm, totals, 4));
						nval.add(new Info(totalm, totals, 6));
						
						Alist.put(p, nval);
					} else {
						List<Info> nval = new ArrayList<>();
						nval.add(new Info(totalm, totals, 1));
						nval.add(new Info(totalm, totals, 3));
						nval.add(new Info(totalm, totals, 5));
						nval.add(new Info(totalm, totals, 7));
						
						Alist.put(p, nval);
					}
				} else {
					Alist.put(p, val);
				}
			}
			
			list = new HashMap<>(Alist);
			Alist.clear();
		}
		
		int result = 0;
		
		for(String p : list.keySet()) {
			List<Info> val = list.get(p);
			
			for(Info i : val) {
				result += i.m;
			}
		}
		
		System.out.println(result);
	}
	
	static class Info {
		int m;
		int s;
		int d;
		
		public Info(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
}
