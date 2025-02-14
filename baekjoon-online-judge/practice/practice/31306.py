S = input()
vowels = "aeiou"
vowel_cnt = 0
y_cnt = 0
for char in S :
    if char == "y" : y_cnt += 1
    elif char in vowels :
        vowel_cnt += 1
print(vowel_cnt, vowel_cnt + y_cnt)
