for i in range(1, int(input()) + 1) :
    rank = int(input())
    res = "Round 1"
    if rank <= 25 : res = "World Finals"
    elif rank <= 1000 : res = "Round 3"
    elif rank <= 4500 : res = "Round 2"
    print(f'Case #{i}: {res}')
