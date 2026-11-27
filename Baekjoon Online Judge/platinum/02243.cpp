#include <cmath>
#include <iostream>
#include <vector>

#define SIZE 1000000

using namespace std;

vector<int> tree((1 << ((int)ceil(log2(SIZE)) + 1)));

void update(int start, int end, int idx, int diff, int node = 1)
{
    if (end < idx || idx < start) return;
    tree[node] += diff;
    if (start == end) return;
    int mid = (start + end) / 2;
    update(start, mid, idx, diff, node*2);
    update(mid+1, end, idx, diff, node*2 +1);
}


int query(int start, int end, int idx, int node = 1)
{
    --tree[node];
    if (start == end) return start;
    int mid = (start + end) / 2;
    if (tree[node*2] >= idx) return query(start, mid, idx, node*2);
    else return query(mid+1, end, idx - tree[node*2], node*2 +1);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    cin >> N;
    int A, B, C;
    while (N--) {
        cin >> A >> B;
        if (A == 1) cout << query(1, SIZE, B) << '\n';
        else {
            cin >> C;
            update(1, SIZE, B, C);
        }
    }
}
