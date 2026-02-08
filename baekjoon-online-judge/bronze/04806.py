if __name__ == '__main__':
    cnt = 0
    while True:
        try:
            input()
        except EOFError:
            break
        cnt += 1
    print(cnt)
