#include <cmath>
#include <vector>
#include <iostream>

#define SIZE 2000000

using namespace std;

vector<int> tree(1 << ((int)ceil(log2(SIZE))+ 1));

void update(int start, int end, int X, int node = 1)
{
    if (end < X || X < start) return;
    ++tree[node];
    if (start == end) return;
    int mid = (start + end)/2;
    update(start, mid, X, node*2);
    update(mid+1, end, X, node*2 +1);
}

int query(int start, int end, int X, int node = 1)
{
    --tree[node];
    if (start == end) return start;
    int mid = (start + end)/2;
    if (tree[node*2] >= X) return query(start, mid, X, node*2);
    else return query(mid+1, end, X - tree[node*2], node*2 +1);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, S, X;
    cin >> N;
    while (N--) {
        cin >> S >> X;
        if (S == 1) update(1, SIZE, X);
        else cout << query(1, SIZE, X) << '\n';
    }
}
