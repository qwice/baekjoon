import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine();
        int len = s.length();
        
        int q = Integer.parseInt(br.readLine());
        
        int[][] prefix = new int [26][len+1];
        
        for(int i = 0 ; i < len ; i++){
            int charIdx = s.charAt(i) - 'a';
            for(int j = 0 ; j < 26 ; j++){
                prefix[j][i+1] = prefix[j][i] + (j == charIdx ? 1 : 0);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < q ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char alpha = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int alphaIdx = alpha - 'a';
            int count = prefix[alphaIdx][r + 1] - prefix[alphaIdx][l];
            sb.append(count).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}