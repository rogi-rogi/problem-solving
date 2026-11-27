if __name__ == '__main__':
    for i in range(1, int(input())+1):
        E, A = map(int, input().split())
        cnt = 0
        while E > A:
            A *= 5
            cnt += 1
        res = ('no ' if cnt == 0 else 'mega ' * (cnt - 1)) + 'drought'
        print(f'Data Set {i}:\n{res}\n')
