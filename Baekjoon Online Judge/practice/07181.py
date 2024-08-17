from sys import stdin
input=stdin.readline

if __name__ == '__main__':
    password = input().rstrip()
    N = int(input())
    for _ in range(N):
        t = input().rstrip()
        a, b = 0, 0
        for i in range(4):
            if t[i] in password:
                a += 1
            if t[i] == password[i]:
                b += 1
        print(a, b)
