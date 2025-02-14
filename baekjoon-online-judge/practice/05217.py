for _ in range(int(input())):
    n = int(input())
    start = 1
    res = "Pairs for " + str(n) + ": "
    
    for i in range(1, n // 2 + 1):
        if i != n-i:
            if i != 1:
                res += ", "
            res += str(i) + " " + str(n - i)
    print(res)
