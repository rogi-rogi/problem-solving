from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    no = 1
    other_msg = ['Par', 'Birdie', 'Eagle', 'Double eagle', 'Bogey']
    res = ''
    while True:
        # Input
        P, S = map(int, input().split())
        if P == S == 0: break
        
        # Solve
        if S == 1: res = 'Hole-in-one'
        elif P - S <= -2:
            res = 'Double Bogey'
        else:
            res = other_msg[P - S]
            
        # Output
        print(f'Hole #{no}\n{res}.\n')
        no += 1
