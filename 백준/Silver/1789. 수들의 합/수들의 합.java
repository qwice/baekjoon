import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Long S = Long.parseLong(br.readLine());
        
        Long sum = 0L;
        
        for(Long i = 1L; ; i++){
          if(sum + i < S) {
            sum += i;
          }
          if(S - sum <= i) {
            System.out.print(i);
            return;
          }
        }
    }
}
