from itertools import combinations

if __name__ == '__main__':
    f = input()
    stack = []
    pair = []
    for i in range(len(f)):
        if f[i] == '(':
            stack.append(i)
        elif f[i] == ')':
            pair.append((stack.pop(), i))
    res = []
    for i in range(1, len(pair) + 1):
        for comb in combinations(pair, i):
            new_f = [*f]
            for left, right in comb:
                new_f[left] = new_f[right] = ''
            res.append(''.join(new_f))
    print(*sorted(set(res)), sep='\n')
