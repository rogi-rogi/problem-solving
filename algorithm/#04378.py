keybord = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;\'ZXCVBNM,./"
while True :
    try :
        res = ""
        for char in input() :
            if char != ' ' :
                res += keybord[keybord.index(char) - 1]
            else : res += ' '
        print(res)
    except : break
