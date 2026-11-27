from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    for TC in range(1, int(input()) + 1):
        input()

        # Solve
        cnt = [*input().split()].count("sheep")

        # Output
        print(f'Case {TC}: This list contains {cnt} sheep.\n')
