from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    res = []

    # Input
    for TC in range(1, int(input()) + 1):
        res.append(f'Case {TC}:')
        for i in range(int(input())):
            N = int(input())
            
            # Solve
            if N < 6:
                res.append(N + 1)

    # Output
    print(*res, sep='\n')
    
