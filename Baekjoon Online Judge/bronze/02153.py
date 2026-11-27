word_sum = 0
for i in input() :
    word_sum += ord(i) - (96 if i.islower() else 38)
prime_list = [1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31] #max : 1040^(1/2)
if word_sum not in prime_list :
    is_prime = not any(p for p in prime_list[1:] if word_sum % p == 0)
else : is_prime = True
print("It is " +("" if is_prime else "not " )+ "a prime word.")
