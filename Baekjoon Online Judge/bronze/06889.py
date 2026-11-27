n = int(input())
m = int(input())

str1 = [input() for _ in range(n)]
str2 = [input() for _ in range(m)]

for s1 in str1 :
    for s2 in str2 :
        print(s1, "as", s2)
