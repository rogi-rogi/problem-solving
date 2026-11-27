for _ in range(int(input())):
    odd, even = 0, 0
    for n in [*map(int, input().split())][1:]:
        if n % 2 == 1:
            odd += n
        else:
            even += n
    res = "TIE"
    if odd > even:
        res = "ODD"
    elif odd < even:
        res = "EVEN"
    print(res)