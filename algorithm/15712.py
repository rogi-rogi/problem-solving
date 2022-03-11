def f(n) :
    if n == 1 : return a % mod
    return (f(n//2) * (pow(r, n//2,mod) + 1)+ (a*pow(r,n-1,mod) if n % 2 else 0)) % mod
  
if __name__ == "__main__" :
    a, r, n, mod = map(int, input().split())
    print(f(n))
