from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    for _ in range(int(input())) :
        stack = list(input().rstrip())
        VPS = 0
        while stack :
            VPS += 1 if stack.pop() == ')' else -1
            if VPS < 0 : break
        print("NO" if VPS else "YES") 
    
