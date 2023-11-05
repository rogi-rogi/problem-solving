if __name__ == "__main__" :
    N, a = map(int, input().split())
    MOD = int(1e9+7)
    res = (N-1)*pow(N-1,a-1, MOD)
    A = pow(N, a-1, MOD)*(N-1)%MOD
    R = (N-1)/N
    print(int((res+(A-((1/N)*pow(N-1,a+1,MOD)))/(1-R))*N)%MOD)
