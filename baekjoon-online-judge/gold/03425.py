from sys import stdin
input = stdin.readline

def GoStack(num) :
    stack = [num]
    for cmd in command :
        if cmd[:3] == "NUM" : stack.append(int(cmd[4:]))
        elif not stack : return "ERROR"
        elif cmd == "POP" : stack.pop()
        elif cmd == "INV" : stack[-1] *= -1
        elif cmd == "DUP" : stack.append(stack[-1])
        elif len(stack) <= 1 : return "ERROR"
        elif cmd == "SWP" : stack[-1], stack[-2] = stack[-2], stack[-1]
        elif cmd == "ADD" : stack[-1] = stack.pop() + stack[-1]
        elif cmd == "SUB" : stack[-1] = -stack.pop() + stack[-1]
        elif cmd == "MUL" : stack[-1] = stack.pop() * stack[-1]
        elif cmd == "DIV" :
            temp = stack.pop()
            if temp == 0 : return "ERROR"
            stack[-1] = int(stack[-1] / temp)
        elif cmd == "MOD" :
            a = stack.pop()
            if a == 0 : return "ERROR"
            temp = abs(stack[-1]) % abs(a)
            if stack[-1] < 0 : temp = -temp
            stack[-1] = temp
        else : return "ERROR"
        if stack and abs(stack[-1]) > 10 ** 9 : return "ERROR"
    return stack[0] if len(stack) == 1 else "ERROR"
        
if __name__ == "__main__" :
    while True :
        command = []
        while True :
            line = input().rstrip()
            if line == "END" : break
            if line == "QUIT" : quit(0)
            command.append(line)
        for _ in range(int(input())) : print(GoStack(int(input())))
        print()
        input()
