#include<stdio.h>

int main(){
    int N, cnt = 1667, x, y;
    scanf("%d", &N);
    for(x = 0; x <= 1000; x++){
        for(y = 0; y <= 1667; y++){
            if(5 * x + 3 * y == N && x + y < cnt) cnt = x+y;
        }
    }
    if(cnt == 1667) printf("-1");
    else printf("%d", cnt);
}