bowls = input()
result = 10
for i in range(1, len(bowls)) :
    result += 5 if bowls[i] == bowls[i - 1] else 10
print(result)
