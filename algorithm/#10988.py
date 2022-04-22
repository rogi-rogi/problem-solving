word = input()
size = len(word)
palindrome = True
for i in range(size // 2) :
    if word[i] != word[size - 1 - i] :
        palindrome = False
        break
print(1 if palindrome else 0)
