word = input()
for i in ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="] :
    word = word.replace(i, 'C')
print(len(word))
