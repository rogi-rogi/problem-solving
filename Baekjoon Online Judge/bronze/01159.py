alpha = [0] * 26
for _ in range(int(input())) :
    alpha[ord(input()[0]) - 97] += 1
surrender = True
res = ""
for i in range(26) :
    if alpha[i] >= 5 : 
        surrender = False
        res += chr(i + 97)
print("PREDAJA" if surrender else res)
