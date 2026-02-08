input()
A = [*input().split()]
B = input()
cnt = 0
for a in A :
    if a == B :
        cnt += 1
print(cnt)
