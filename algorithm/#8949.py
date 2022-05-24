A, B = input().split()
A, B = A[::-1], B[::-1]
res = ""
while True :
    res += str(eval(A[0] + "+" + B[0]))[::-1]
    if len(A) > 1 and len(B) > 1 :
        A, B = A[1:], B[1:]
    else :
        if len(A) > 1 : res += A[1:]
        if len(B) > 1 : res += B[1:]
        res = res[::-1]
        break
print(res)
