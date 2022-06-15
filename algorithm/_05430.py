from collections import deque

if __name__ == "__main__" :
    for _ in range(int(input())) :
        P = [*input()]
        n = int(input())
        error = False
        if n == 0 : 
            input()
            error = True
        else :
            X = deque([*map(int, input()[1:-1].split(','))])
            reverse = False
            for p in P :
                if p == 'R' :
                    reverse = not reverse
                    continue
                if X :
                    if reverse : X.pop()
                    else : reverse : X.popleft()
                if not X :
                    error = True
                    break
        print("error" if error else str([*X][::[1, -1][reverse]]).replace(' ', ''))
        
