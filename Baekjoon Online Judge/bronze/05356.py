alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
for _ in range(int(input())) :
    n, char = input().split()
    idx = ord(char) - ord('A')
    for i in range(1, int(n) + 1) :
        print(alpha[idx] * i)
        idx = (idx + 1) % 26
    print()
