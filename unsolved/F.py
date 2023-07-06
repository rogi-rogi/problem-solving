if __name__ == "__main__" :
    N, a = map(int, input().split())
    MOD = 1e9 + 7
    if a == 1 : print(2*(N * (N-1)) % MOD)
    else :
        L = 1
        # 변의 길이가 1인 도형들의 둘레 : (N-1) * (N-1)^(a-1) = (N-1)^a
        ans = pow(N-1, a, MOD)
        # N - 1개의 연속된 패턴을 가지는 도형의 둘레 계산.
        for _ in range(a - 2) :
            # 구하고자 하는 연속된 패턴을 가지는 도형들의 둘레 : (N-1)*L/N*(N-1)*(N-1)
            # L = N^a, L/N = N^(a-1), L을 N이 아닌, 1부터 N배 해주면 L/N = L이 성립한다.
            # L*(N-1)^3
            ans = (ans + L*pow(N-1, 3, MOD))%MOD
            L = (L*N)%MOD
        
        # N 패턴 도형의 둘레 : 
        ans = (ans + L*pow(N-1, 2, MOD))%MOD
        
        # N-1 패턴과 N패턴 도형 둘레를 N배
        ans = N*ans%MOD
        
        # 중심 도형의 둘레 : 4 * (N - 1) * N^(a-1)
        ans = (ans + pow(N, a-1, MOD) * 4*(N-1)%MOD)%MOD
        print(ans)
