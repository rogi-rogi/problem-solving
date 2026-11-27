#include <stdio.h>
#include <memory.h>
char arr[3072][6144];
void mark_star(int row, int col, int N){
    if (N == 3){
        arr[row][col] = '*';
        arr[row+1][col-1] = '*';
        arr[row+1][col+1] = '*';
        arr[row+2][col-2] = '*';
        arr[row+2][col-1] = '*';
        arr[row+2][col] = '*';
        arr[row+2][col+1] = '*';
        arr[row+2][col+2] = '*';
    }else {
        mark_star(row, col, N/2);
        mark_star(row + N/2, col - N/2, N/2);
        mark_star(row + N/2, col + N/2, N/2);
    }
}
int main(){
    int N;
    scanf("%d", &N);
    memset(arr, ' ', sizeof(arr));
    mark_star(0, N-1, N);
    for (int i = 0; i < N; i++){
        for (int j = 0; j < 2*N; j++)
            putchar(arr[i][j]);
        putchar(10);
    }
}