while True :
    string = input()
    if string[0] == '#' : break
    cnt = 0
    for s in string :
        if s in "aeiouAEIOU" :
            cnt += 1
    print(cnt)
