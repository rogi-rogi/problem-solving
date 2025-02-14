from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    res = sorted([input().split() for _ in range(51)], key=lambda x: (x[0], int(x[1])))
    
    # Solve
    res.append(['S', 13])
    for i in range(4):
        for j in range(1, 14):
            if res[i*13 + j - 1][1] != str(j):
                
                # Output
                print("BKSV"[i], j)
                exit(0)
