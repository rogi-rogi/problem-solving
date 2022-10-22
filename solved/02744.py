res = ""
for i in list(input()) :
    res += i.upper() if i.islower() else i.lower()
print(res)
