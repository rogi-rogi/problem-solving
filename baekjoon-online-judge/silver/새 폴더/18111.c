#include <stdio.h>
int main(){
	int N, M, B, arr[257] = {0, }, temp, max = 0;
	scanf("%d %d %d", &N, &M, &B);
	for (int i = 0; i < N*M; i++){
		scanf("%d", &temp);
		arr[temp]++;
		max < temp && (max = temp);
	}
	int result = 128000000, height;
	for (int flatLand = max; flatLand >= 0; flatLand--){
		int set = 0, remove = 0;
        for (int i = 0; i < 257; i++)
        	if (arr[i])
            	if (i < flatLand)
                	set += arr[i]*(flatLand-i);
            	else if (i > flatLand)
                	remove += arr[i]*(i-flatLand);

        int time = set + remove*2;
        int inventory = B + remove - set;
        if (time < result && inventory >= 0){
        	height = flatLand;
			result = time;
		}
	}
	printf("%d %d\n", result, height);
}