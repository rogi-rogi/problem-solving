from sys import stdin
input = stdin.readline

def bt(cur, cnt):
    global ans
    if cur == N or cnt == N - 1:
        if cnt > ans:
            ans = cnt    
        return
    if S[cur] <= 0:
        bt(cur + 1, cnt)
        return
    for i in range(N):
        if i != cur and S[i] > 0:
            S[cur] -= W[i]
            S[i] -= W[cur]
            bt(cur + 1, cnt + (S[cur] <= 0) + (S[i] <= 0))
            S[cur] += W[i]
            S[i] += W[cur]

if __name__ == '__main__':
    ans = 0
    N = int(input())
    S = []
    W = []
    for _ in range(N):
        s, w = map(int, input().split())
        S.append(s)
        W.append(w)
    bt(0, 0)
    print(ans)
