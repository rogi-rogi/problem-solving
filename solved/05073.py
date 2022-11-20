while True :
    a, b, c = sorted([*map(int, input().split())])
    res = ""
    if a == 0 : break
    elif a + b <= c : res = "Invalid"
    elif a == b == c : res = "Equilateral"
    elif a == b or b == c: res = "Isosceles"
    elif a != b and b != c and c != a : res = "Scalene"
    print(res)
