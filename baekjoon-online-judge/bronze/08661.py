from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    X, K, A = map(int, input().split())

    # Solve & Output
    print([0, 1][(X % (K + A)) - K < 0])
    
