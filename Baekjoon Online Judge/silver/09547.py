from sys import stdin
input = stdin.readline

for _ in range(int(input())) :
    C, V = map(int, input().split())
    v_list = []
    for _ in range(V) :
        v_list.append(list(map(int, input().split())))
    who = {}    # {no: cnt}
    for i in range(V) : 
        if who.get(v_list[i][0]) : who[v_list[i][0]] += 1
        else : who[v_list[i][0]] = 1
    max_idx = max(who.keys(), key = lambda x : who[x])
    if who[max_idx] > V // 2 : #1
        print(max_idx, 1)
    else : #2
        temp = {}
        for no, _ in sorted(who.items(), key = lambda x : x[1])[-2:] : temp[no] = 0
        who = temp
        for i in v_list :
            for j in i :
                if j in list(who.keys()) :
                    who[j] += 1
                    break
        print(max(who.keys(), key = lambda x : who[x]), 2)
