from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    stack = []
    for _ in range(int(input())) :
        cmd = input().split()
        if cmd[0] == "push" : stack.append(cmd[1])
        elif cmd[0] == "pop" :  print(stack.pop() if stack else -1)
        elif cmd[0] == "size" : print(len(stack))
        elif cmd[0] == "empty" : print(0 if len(stack) else 1)
        else : print(stack[-1] if stack else -1)
