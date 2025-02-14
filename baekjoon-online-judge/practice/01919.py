if __name__ == '__main__':
    alpha = [0] * 26
    for char in input():
        alpha[ord(char) - 97] += 1
    for char in input():
        alpha[ord(char) - 97] -= 1
    print(sum([*map(abs, alpha)]))
