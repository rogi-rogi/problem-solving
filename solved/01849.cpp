#include <cmath>
#include <iostream>
#include <vector>

#define SIZE 100000

using namespace std;

vector<int> tree((1 << ((int)ceil(log2(SIZE)) + 1))), diff(SIZE +1), res(SIZE +1);

void init(int start, int end, int node = 1)
{
    if (start == end) ++tree[node];
    else {
        int mid = (start + end)/2;
        init(start, mid, node*2);
        init(mid+1, end, node*2 +1);
        tree[node] = tree[node*2] + tree[node*2 +1];
    }
}

int query(int start, int end, int idx, int node = 1)
{
    --tree[node];
    if (start == end) return start;
    int mid = (start + end) / 2;
    if (tree[node*2] > idx) return query(start, mid, idx, node*2);
    else return query(mid+1, end, idx - tree[node*2], node*2 +1);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    {
        cin >> N;
        diff.resize(N + 1);
        res.resize(N + 1);
        init(1, N);
        for (int i = 1; i <= N; ++i) cin >> diff[i];
    }
    /*
        i 앞에 있는 수 들 중, i보다 큰 수들의 개수가 A[i]이다.
        원래 수열을 구하기 위해서는 i보다 큰 수가 A[i]개 만큼 자신보다 앞 공간에 들어가야 한다.
        (= 남은 공간 중 A[i] + 1 번째의 위치를 찾아서 i를 저장해주면 된다)
    */
    for (int i = 1; i <= N; ++i) res[query(1, N, diff[i])] = i;
    for (int i = 1; i <= N; ++i) cout << res[i] << '\n';
    
}
