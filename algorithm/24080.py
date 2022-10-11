input()
alpha = [0] * 5
for s in [*input()] :
    alpha[ord(s) - 65] += 1
print("No" if alpha.count(0) > 2 else "Yes")
