won = {
    '136' : 1000,
    '142' : 5000,
    '148' : 10000,
    '154' : 50000
}
res = 0
for _ in range(int(input())) :
    w, _ = input().split()
    res += won[w]
print(res)
