from collections import deque

if __name__ == "__main__" :
    for _ in range(int(input())) :
        P = [*input()]
        n = int(input())
        X = deque([input()[1:-1].split(',')])
        reverse = False
        for p in P :
            if p == 'R' :
                reverse = not reverse
            elif X :
                if reverse : X.pop()
                else : reverse : X.popleft()
            else :
                print("error")
                break
        print()
            
        
        
