from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    for _ in range(int(input())):
        input()

        # Solve & Output
        print(sum(map(int, input().split())))
        
