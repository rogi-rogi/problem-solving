import string

text = input()
for alphabet in string.ascii_uppercase :
    if alphabet not in text :
        print(alphabet)
        break
