if __name__ == "__main__" :
    N = int(input())
    click_cnt = abs(N - 100) # all click : '+' or '-'
    M = int(input())
    btn = set()
    if M != 0 : btn = set(input().split())
    
    for num in range(1_000_000) : # btn_create_num(999,999) -> target(0)
        for b in str(num) :
            if b in btn : break 
        else :
            click_cnt = min(click_cnt, len(str(num)) + abs(N - num))
    print(click_cnt)
