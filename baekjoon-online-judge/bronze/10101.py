degree = sorted([int(input()) for _ in range(3)])
if sum(degree) == 180 :
    if degree[0] == degree[1] == degree[2] : res = "Equilateral"
    elif degree[0] != degree[1] != degree[2] : res = "Scalene"
    else : res = "Isosceles"
else : res = "Error"
print(res)
