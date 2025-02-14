N = int(input())
A = [1, 2]
num = 2
for _ in range(N - 2) :
    while True :
        num += 1
        for a in A :
            if (a * num) % (a + num) == 0 :
                break
        else : 
            A.append(num)
            break
print(*A)
