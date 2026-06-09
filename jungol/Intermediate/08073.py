from sys import stdin

input = stdin.readline

def i(a):
    stack.append(int(a))

def o():
    return stack.pop() if stack else 'empty'

def c():
    return len(stack)

if __name__ == '__main__':
    stack = []
    answer = []

    # Input
    for _ in range(int(input())):
        command = input().split()

        # Solve
        # push
        if command[0] == 'i':
            i(command[1])

        # pop
        elif command[0] == 'o':
            answer.append(o())

        # count
        elif command[0] == 'c':
            answer.append(c())

    # Output
    print(*answer, sep='\n')