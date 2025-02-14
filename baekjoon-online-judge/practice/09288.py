from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    res = []
    for i in range(int(input())):
        N = int(input())

        # Solve
        res.append(f'Case {i + 1}:')
        for a in range(1, 7):
            for b in range(a, 7):
                if a + b == N:
                    res.append(f'({a},{b})')

    # Output
    print(*res, sep='\n')
    
