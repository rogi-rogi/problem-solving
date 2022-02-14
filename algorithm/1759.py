#combinations
from itertools import combinations

if __name__ == "__main__" : 
    L, C = map(int, input().split())
    for word in list(combinations(sorted(list(input().split())), L)) : 
        vowel = consonant = 0
        for char in word :
            if char in "aeiou" : vowel += 1
            else : consonant += 1
            if vowel > 0 and consonant > 1 :
                print("".join(word))
                break
