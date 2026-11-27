grade = input()
if grade == 'F' : print(0.0)
else :
    res = (69.0 - ord(grade[0]))
    if grade[1] == '0' : print(res)
    else : print(res + (0.3 if grade[1] == '+' else -0.3))
