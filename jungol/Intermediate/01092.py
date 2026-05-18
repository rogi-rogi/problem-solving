MOD = 20_091_024

if __name__ == '__main__':
    # Input
    X, Y = map(int, input().split())

    # Solve & Output
    print(pow(X, Y, MOD))