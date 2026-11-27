res = 0;
for _ in range(int(input())) :
    a, b, c = map(int, input().split())
    if a == b == c :        res = max(res, 10000+a*1000)
    elif a == b or c == a : res = max(res, 1000 +a*100)
    elif b == c:            res = max(res, 1000 +b*100)
    else :                  res = max(res, max(a,b,c)*100)
print(res)
        
