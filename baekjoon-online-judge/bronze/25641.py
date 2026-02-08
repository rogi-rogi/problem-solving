N = int(input())
ST = [*input()]
cnt = {'s' : ST.count('s'), 't' : ST.count('t')}
for st in ST :
    if cnt['s'] != cnt['t'] :
        N -= 1
        cnt[st] -= 1
    else : break
print(*ST[-N : ], sep = '')
