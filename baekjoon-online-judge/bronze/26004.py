input()
emoji_list = {'H':0, 'I':0, 'A':0, 'R':0, 'C':0}
for s in input() :
    if s in "HIARC" : emoji_list[s] += 1
print(min(emoji_list.values()))
