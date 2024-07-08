if __name__ == '__main__':
    for _ in range(int(input())):
        num = input()
        half = len(num) // 2 - 1
        print(['Do-it-Not', 'Do-it'][num[half] == num[half + 1]])
