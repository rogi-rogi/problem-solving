N = int(input())
f = list(input())
for i in range(N) :
    num = input()
    for idx, val in enumerate(f) :
        if val == chr(ord("A") + i) :
            f[idx] = num
stack = []
for i in f :
    if i.isdigit() : stack.append(i)
    else :
        n2 = stack.pop()
        n1 = stack.pop()
        stack.append(eval(str(n1) + i + str(n2)))
print("%.2f" %stack[0])
