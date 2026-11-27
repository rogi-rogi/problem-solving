A, B = [*map(int, input())], [*map(int, input())]
phone_num = [0] * 16
for i in range(8) :
    phone_num[2 * i] = A[i]
    phone_num[2 * i + 1] = B[i]
for _ in range(14) :
    temp = []
    for i in range(len(phone_num) - 1):
        temp.append((phone_num[i] + phone_num[i + 1]) % 10)
    phone_num = temp
print(*phone_num, sep='')
