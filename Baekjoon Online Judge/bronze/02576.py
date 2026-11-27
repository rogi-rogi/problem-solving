odd = []
for num in [int(input()) for _ in range(7)] :
    if num % 2 : odd.append(num)
if odd : print(sum(odd), min(odd), sep='\n')
else : print(-1)
