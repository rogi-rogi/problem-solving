A = [*input().split()]
B = input()
SIZE = len(B)
cnt = 0
for a in A :
    is_same = True
    if a != B and a[:SIZE] == B : cnt += 1
print(cnt)
