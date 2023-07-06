if __name__ == "__main__" :
    ans = [0, 0, 0, 0] # SW, HW, AI, none
    for _ in range(int(input())) :
        g, c, _ = map(int, input().split())
        if g == 1 : ans[3] += 1
        else :
            if c <= 2 : ans[0] += 1
            elif c == 3 : ans[1] += 1
            else : ans[2] += 1
    print(*ans, sep='\n')
