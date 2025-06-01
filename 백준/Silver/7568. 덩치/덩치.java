import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Person> people = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    static class Person{
      int x, y;
      
      public Person(int x, int y){
        this.x = x;
        this.y = y;
      }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        for(int i = 0 ; i < N ; i++){
          st = new StringTokenizer(br.readLine());
          int x = Integer.parseInt(st.nextToken());
          int y = Integer.parseInt(st.nextToken());
          people.add(new Person(x, y));
        }
        
        for(Person t : people){
          int grade = 1;
          for(Person q : people){
            if(t.x < q.x && t.y < q.y) grade++;
          }
          sb.append(grade).append(" ");
        }
        
        System.out.print(sb);
    }
}
