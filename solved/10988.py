word = input()
palindrome = True
for i in range(len(word) // 2) :
    if word[i] != word[-1 - i] :
        palindrome = False
        break
print(1 if palindrome else 0)
