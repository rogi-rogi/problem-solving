for _ in range(int(input())):
    A, B = input().split()
    print(int(str(int(A[::-1]) + int(B[::-1])) [::-1]))
