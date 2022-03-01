from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    text = list(input().rstrip())
    cursor = len(text)
    stack = []
    for _ in range(int(input())) :
        cmd = input().rstrip()
        if cmd[0] == 'P' :
            text.append(cmd[2]);
            cursor += 1
        elif cmd[0] == 'L' :
            if text : stack.append(text.pop())
            cursor -= 1
        elif cmd[0] == 'D' and stack :
            text.append(stack.pop())
            cursor += 1
        elif cmd[0] == 'B' and text:
            text.pop()
            cursor -= 1
    text += reversed(stack)
    print(''.join(text))
