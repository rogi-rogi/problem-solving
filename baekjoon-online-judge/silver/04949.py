left_bracket = '[('
right_bracket = '])'
while True :
    string = input()
    if string == '.' : break
    stack = []
    balance = True
    for s in string :
        if s in left_bracket :
            stack.append(s)
        elif s == right_bracket[0] :
            if not stack or stack.pop() != left_bracket[0] :
                balance = False
                break
        elif s == right_bracket[1] :
            if not stack or stack.pop() != left_bracket[1] :
                balance = False
                break
    if stack : balance = False
    print(["no", "yes"][balance])
