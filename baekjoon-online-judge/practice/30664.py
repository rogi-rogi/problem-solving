if __name__ == '__main__':
    while True:
        N = int(input())
        if N == 0:
            break
        print(["TENTE NOVAMENTE", "PREMIADO"][N % 42 == 0])
