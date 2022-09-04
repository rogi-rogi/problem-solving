#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int strokes[26] = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    string A, B;
    cin >> A >> B;
    vector<int> res;
    for (int i = 0; i < A.size(); ++i) {
        res.push_back(strokes[A[i] - 65]);
        res.push_back(strokes[B[i] - 65]);
    }
    
    int res_size = res.size();
    while (res_size > 2) {
        vector<int> temp;
        for (int i = 0; i < res_size - 1; ++i)
            temp.push_back((res[i] + res[i + 1]) % 10);
        res = temp;
        --res_size;
    }
    cout << res[0] << res[1];
}
