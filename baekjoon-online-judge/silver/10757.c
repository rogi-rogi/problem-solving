#include <stdio.h>
#include <string.h>
void str_rev(char *str, int len){
	for (int i = 0; i < len/2; i++){
		str[i] = str[i] ^ str[len-i-1];
		str[len-i-1] = str[len-i-1] ^ str[i];
		str[i] = str[i] ^ str[len-i-1];
	}
}
int main(){
	char A[10002] = {0,}, B[10002] = {0,}, C[10003] = {0,};
	scanf("%s %s", A, B);
	int lenA = strlen(A), lenB = strlen(B);
	str_rev(A, lenA);
	str_rev(B, lenB);
	int carry = 0, len = lenA > lenB ? lenA : lenB;
	for (int i = 0; i < len; i++){
		int num = A[i] + B[i]- '0'*2 + carry;
		while (num < 0) num += '0';
		C[i] = num%10 + '0';
		carry = (num > 9 ? 1 : 0);
	}
	carry && (C[len] = '1');
	str_rev(C, strlen(C));
	printf("%s", C);
}