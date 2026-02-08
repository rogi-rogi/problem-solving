message = input()
res = ""
idx = 0
SIZE = len(message)
while idx < SIZE - 1 :
    res += message[idx]
    idx +=  ord(message[idx]) - 64
print(res + message[-1])
