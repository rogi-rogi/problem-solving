if __name__ == '__main__':
    res = ['even' if int(input()) % 2 == 0 else 'odd' for _ in range(int(input()))]
    print(*res, sep='\n')
