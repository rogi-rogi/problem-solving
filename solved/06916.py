N = int(input())

print(" * * *" if N != 1 and N != 4 else '')

for _ in range(3) :
    if N == 0 or N == 4 or N == 8 or N == 9 : print("*     *")
    elif N == 5 or N == 6 : print('*')
    else : print("      *")
    
print(" * * *" if N != 0 and N != 1 and N != 7 else '')

for _ in range(3) :
    if N == 0 or N == 6 or N == 8 : print("*     *")
    elif N != 2 : print("      *")
    else : print('*')
    
print(" * * *" if N != 1 and N != 4 and N != 7 else '')
