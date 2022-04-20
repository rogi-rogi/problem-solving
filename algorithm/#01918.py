def PIS(op) : # Priority in stack
    res = -1
    if op == '*' or op == '/' : res = 2
    elif op == '+' or op == '-'  : res = 1
    elif op == '(' : res = 0
    return res

def PIE(op) : # Priority in expression
    res = -1
    if op == '*' or op == '/' : res = 2
    elif op == '+' or op == '-'  : res = 1
    elif op == '(' : res = 3
    return res
    
if __name__ == "__main__" :
    res = []
    stack = [] # input op
    for i in list(input()):
        if i.isalpha() : res.append(i)
        elif i == ')' :
            while stack[-1] != '(' :
                res.append(stack.pop())
            stack.pop()
        else :
            while stack and PIS(stack[-1]) >= PIE(i) :
                res.append(stack.pop())
                if not stack : break
            stack.append(i)
    while stack : res.append(stack.pop())
    print(*res, sep = '')
        
