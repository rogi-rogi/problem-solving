change_char = {'e' : 'i', 'i': 'e', 'E' : 'I', 'I' : 'E'}
while True :
    try :
        string = input()
        res = ''
        for char in string :
            res += change_char[char] if char in change_char.keys() else char
        print(res)
    except : break
