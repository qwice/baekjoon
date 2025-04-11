/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int K;
    static Deque<Integer>[] mag;
    static int[] rotate = new int[4];
    static int result;
    
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
            K=Integer.parseInt(br.readLine());
            mag = new ArrayDeque[4];
            result = 0;
            
			for(int i = 0 ; i < 4 ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                mag[i] = new ArrayDeque<>();
                for(int j = 0 ; j < 8 ; j++){
                    mag[i].add(Integer.parseInt(st.nextToken()));
                }
            }
            
            for(int i = 0 ; i < K ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken()) - 1;
                int dir = Integer.parseInt(st.nextToken());
                Arrays.fill(rotate, 0);
                
                rotate[num] = dir;
                
                for(int j = num - 1 ; j >= 0 ; j--){
                    int left = getIndex(mag[j], 2);
                    int right = getIndex(mag[j + 1] , 6);
                    if(left != right) rotate[j] = -rotate[j+1];
                    else break;
                }
                for(int j = num + 1 ; j < 4 ; j++){
                    int left = getIndex(mag[j - 1], 2);
                    int right = getIndex(mag[j], 6);
                    if(left != right) rotate[j] = -rotate[j - 1];
                    else break;
                }
                
                for(int j = 0 ; j < 4 ; j++){
                    if(rotate[j] == 1) rC(j);
                    else if(rotate[j] == -1) rRC(j);
                }
            }
            
            for(int i = 0 ; i < 4 ; i++){
                result += mag[i].peekFirst() * Math.pow(2, i);
            }
            System.out.println("#"+test_case+" "+result);
		}
	}
    
    static void rC(int j){
        mag[j].addFirst(mag[j].pollLast());
        return;
    }
    
    static void rRC(int j){
       	mag[j].addLast(mag[j].pollFirst());
        return;
    }
    
    static int getIndex(Deque<Integer> deque, int idx){
        Iterator<Integer> it = deque.iterator();
        int i = 0;
        while(it.hasNext()){
            int val = it.next();
            if(idx == i) return val;
            i++;
        }
        return -1;
    }
}