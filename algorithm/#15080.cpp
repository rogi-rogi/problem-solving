#include <iostream>
using namespace std;

int main()
{
    int t1[3], t2[3];
    scanf("%d : %d : %d", &t1[0], &t1[1], &t1[2]);
    scanf("%d : %d : %d", &t2[0], &t2[1], &t2[2]);
    int start_time = t1[0] * 3600 + t1[1] * 60 + t1[2];
    int end_time = t2[0] * 3600 + t2[1] * 60 + t2[2];
    cout << end_time - start_time + (start_time > end_time ? 3600 * 24 : 0);
}
