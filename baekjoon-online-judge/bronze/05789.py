if __name__ == '__main__':
    for _ in range(int(input())):
        num = input()
        res = 'Do-it'
        if len(num) % 2 == 0:
            half = len(num) // 2 - 1
            res = ['Do-it-Not', 'Do-it'][num[half] == num[-half - 1]]
        print(res)
