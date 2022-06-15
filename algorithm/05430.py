from collections import deque

if __name__ == "__main__" :
    for i in range(int(input())) :
        P = [*input().replace("RR", '')]
        n = int(input())
        error = False
        if n == 0 :
            input()
            X = list()
        else : X = deque([*input()[1:-1].split(',')])
        reverse = False
        for p in P :
            if p == 'R' :
                reverse = not reverse
            else :
                if X :
                    if reverse : X.pop()
                    else : X.popleft()
                else :
                    error = True
                    break
        print("error" if error else '[' + ','.join([*X][::[1, -1][reverse]]) + ']')
        
