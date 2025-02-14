from sys import stdin
input=stdin.readline

if __name__ == '__main__':
    while True:
        N = int(input())
        if N == 0:
            break
        mary = max(input().count('0'), 0)
        print(f"Mary won {mary} times and John won {N - mary} times")
