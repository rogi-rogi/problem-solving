#include <iostream>
using namespace std;

int main()
{
    int t[3];
    scanf("%d : %d : %d", &t[0], &t[1], &t[2]);
    int start_time = t[0] * 3600 + t[1] * 60 + t[2];
    scanf("%d : %d : %d", &t[0], &t[1], &t[2]);
    int end_time = t[0] * 3600 + t[1] * 60 + t[2];
    cout << end_time - start_time + (start_time > end_time ? 3600 * 24 : 0);
}
