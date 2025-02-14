from sys import stdin
input=stdin.readline

if __name__ == '__main__':
    while True:
        N = int(input())
        if N == 0:
            break
        print(int(N*(N+1)*(2*N+1)/6))
