from operator import itemgetter
from sys import stdin
input = stdin.readline

def isSubString(sub, std) :
    sub_size = len(sub)
    std_size = len(std)
    sub_idx, std_idx = 0, 0
    while sub_idx < sub_size and std_idx < std_size :
        if sub[sub_idx] == std[std_idx] :
            sub_idx += 1
            std_idx += 1
            if sub_idx == sub_size : return True
        else : std_idx += 1
    return False

if __name__ == "__main__" :
    words = []
    while True :
        word = input().rstrip()
        if word == '-' : break
        words.append(sorted(word))
    while True :
        puzzle = input().rstrip()
        if puzzle == '#' : break
        puzzle = sorted(puzzle)
        check = dict()
        for p in puzzle : check[p] = 0
        for word in words :
            if isSubString(word, puzzle) :
                for char in set(word) :
                    check[char] += 1
        check = sorted(check.items(), key = itemgetter(1))
        max_char, min_char = [], []
        for char, cnt in check :
            if cnt == check[0][1] : min_char.append(char)
            if cnt == check[-1][1] : max_char.append(char)
        print(*min_char, ' ', check[0][1], sep = '', end = ' ')
        print(*max_char, sep = '', end = ' ')
        print(check[-1][1])
