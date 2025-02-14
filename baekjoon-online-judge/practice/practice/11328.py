from sys import stdin
input=stdin.readline

for _ in range(int(input())) :
    prev, cur = input().split()
    words = [0] * 26
    for word in prev :
        words[ord(word) - 97] += 1
    for word in cur :
        words[ord(word) - 97] -= 1
    print(['Impossible', 'Possible'][all(word == 0 for word in words)])
