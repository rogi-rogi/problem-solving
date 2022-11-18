for _ in range(4) :
    x1, y1, p1, q1, x2, y2, p2, q2 = map(int, input().split())
    res = 'a'
    if x1 > p2 or y1 > q2 or p1 < x2 or q1 < y2 : res = 'd'
    elif x1 == p2 or p1 == x2 :
        if y1 == q2 or q1 == y2 : res = 'c'
        else : res = 'b' # y1 != q2 or q1 != y2
    elif y1 == q2 or q1 == y2 : res = 'b'
    print(res)
