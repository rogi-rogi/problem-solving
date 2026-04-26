import fnmatch

N = int(input())
words = []
target = ''
idx = 0
for i in range(N) :
    word = input()
    if word != '?' : words.append(word)
    else :
        words.append('*')
        idx = i

if idx > 0 :
    target = words[idx - 1][-1]
target += words[idx]
if idx + 1 < len(words) :
    target += words[idx + 1][0]

for key in [input() for _ in range(int(input()))] :
    if key not in words and fnmatch.fnmatch(key, target) :
        print(key)
        break