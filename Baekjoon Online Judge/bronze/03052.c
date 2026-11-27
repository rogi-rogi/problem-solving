#include <stdio.h>
int main(){
	int arr[42], num, idx = 1;
	for (int i = 0; i < 10; i++){
		scanf("%d", &num);
		num %= 42;
		if (!i)
			arr[0] = num;
		else
			for (int j = 0; j < idx; j++)
				if (arr[j] != num && j == idx - 1){
					arr[j+1] = num;
					idx++;
				}else if (num == arr[j])
					break;
	}
	printf("%d\n", idx);
}