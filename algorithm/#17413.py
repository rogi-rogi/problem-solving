def move() :
    while temp : stack.append(temp.pop())

S = input()
stack = []
temp = []
tag = False
for s in S :
    if s == '<' :
        move()
        tag = True
    if tag :
        if s == '>' : tag = False
        stack.append(s)
    elif s == ' ' :
        move()
        stack.append(s) # for ' '
    else : temp.append(s)
move()
print(*stack, sep = '')
