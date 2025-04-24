import java.io.*;
import java.util.*;

public class Main {
    static int C, L;
    static char[] arr;
    static char[] mA;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new char[C];
        mA = new char[L];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < C ; i++){
          arr[i] = st.nextToken().charAt(0);
        }
        
        Arrays.sort(arr);
        
        makeArr(0, 0);
    }
    
    static void makeArr(int count, int idx){
      if(count == L){
        if(valid(mA)) System.out.println(mA);
        return;
      }
      
      for(int i = idx ; i < C ; i++){
        mA[count] = arr[i];
        makeArr(count+1, i + 1);
      }
    }
    
    static boolean valid(char[] a){
      boolean check = false;
      int count = 0;
      
      for(int i = 0 ; i < L ; i++){
        if(a[i] == 'a' || a[i] == 'e' || a[i] == 'i' || a[i] == 'o' || a[i] == 'u'){
          check = true;
        }
        if(!(a[i] == 'a' || a[i] == 'e' || a[i] == 'i' || a[i] == 'o' || a[i] == 'u')){
          count++;
        }
      }
      
      if(check && count >= 2) return true;
      else return false;
    }
}
