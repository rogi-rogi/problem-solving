from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    S = input().rstrip()
    res = 0
    for i in range(len(S)):
        sub_string = set()
        for j in range(len(S) - i + 1):
            sub_string.add(S[j:j+i])
        res += len(sub_string)
    print(res)
