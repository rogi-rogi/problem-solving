#include <iostream>
using namespace std;

int main()
{
    int nums[4];
    for (int i = 0; i < 4; ++i) cin >> nums[i];
    cout << (((nums[0] == 8 || nums[0] == 9) && (nums[3] == 8 || nums[3] == 9) && (nums[1] == nums[2])) ? "ignore" : "answer");
}
