from functools import cmp_to_key
from sys import stdin
input = stdin.readline


def compare(s1, s2):
    str1, str2 = s1 + s2, s2 + s1
    return 0 if str1 == str2 else [-1, 1][str1 > str2]
    
if __name__ == "__main__" :
    words = [input().rstrip() for _ in range(int(input()))]
    SIZE = sum([len(word) for word in words])
    res = ''
    while len(res) != SIZE and words :
        words.sort(key = cmp_to_key(compare)) # words[0] = good word for query
        good_word = words[0] # first char
        res += good_word[0]
        if len(good_word) > 1 : words[0] = good_word[1:]
        else : words.pop(0)
    print(res)
