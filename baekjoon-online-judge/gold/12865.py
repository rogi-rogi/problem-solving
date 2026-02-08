#default ver
from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N, K = map(int, input().split())
    dp = [[0] * (K + 1) for _ in range(N + 1)]
    for i in range(1, N + 1) :
        W, V = map(int, input().split())
        for j in range(1, K + 1) :
            if j < W :  dp[i][j] = dp[i - 1][j]
            else : dp[i][j] = max(dp[i - 1][j], V + dp[i - 1][j - W])
    print(dp[N][K])
    
#fast ver
'''
선별한 물건들의 무게가 최대 무게(=K) 이하로 물건들의 가치가 최대가 되도록 찾아야 한다.
 "임의의 두 물건들의 무게"(=nw)는 다음과 같이 이용할 수 있다.
 
i)  기존에 이미 동일한 가치를 가지는 물건들이 있고, 그 물건들의 무게보다 nw가 더 가벼운 경우
ii) 기존에 이미 동일한 가치를 가지는 물건들이 없고, nw가 k이하인 경우

모든 물건들에 대해 i, ii인 경우에만 최대 가치에 대한 최소 무게를 갱신해주면, 물건들의 가치에 대한 최댓값을 구할 수 있다.
'''
from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N, K = map(int, input().split())
    dp = {0 : 0}
    for _ in range(N) :
        W, V = map(int, input().split())
        temp = dict()
        for v, w in dp.items() :
            nv, nw = V + v, W + w
            if nw < dp.get(nv, K + 1) :
                temp[nv] = nw
        dp.update(temp)
    print(max(dp.keys()))
