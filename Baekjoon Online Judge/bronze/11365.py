while True :
    password = input()
    if password == "END" : break
    print(*list(password)[::-1], sep = '')
