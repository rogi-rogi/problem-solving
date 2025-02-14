from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    for _ in range(int(input())):
        N, X, Y = map(int, input().split())
        nums = [*map(int, input().split())]

        # Solve
        res = "OKAY"
        if nums[0] == X and nums[-1] == Y:
            res = "BOTH"
        elif nums[0] == X:
            res = "EASY"
        elif nums[-1] == Y:
            res = "HARD"

        # Output
        print(res)
        
