from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    for _ in range(int(input())) :
        prev = '.' # None
        move = 0 # ['BLACK', 'WHITE'][move > 0]
        cnt = 0
        S = input().rstrip()
        for stone in S[::-1] :
            if prev == '.' : # None or change stone
                prev = stone
            if prev == '.' : # sequence None
                continue
            
            if stone == '.' : # and sequence None
                move += cnt * [-1, 1][prev == 'W']
            elif stone == prev : # count same stone
                cnt += 1
            else :
                cnt = 0
                prev = '.' # None
        print(['BLACK', 'WHITE'][move > 0])
