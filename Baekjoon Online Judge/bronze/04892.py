TC = 1
while True:
    n0 = int(input())
    if n0 == 0:
        break
    n1 = 3 * n0
    n2 = [(n1+1) // 2 , n1 // 2][n1%2 == 0]
    n3 = 3 * n2
    n4 = n3 // 9
    if n0 == 2 * n4:
        print(f"{TC}. even {n4}")
    else:
        print(f"{TC}. odd {n4}")
    TC += 1
