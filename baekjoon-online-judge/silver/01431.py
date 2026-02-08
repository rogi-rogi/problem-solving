def get_sum(x) :
    return sum(int(c) for c in x if c.isdigit())

if __name__ == '__main__':
    N = int(input())
    serial = [input() for _ in range(N)]
    serial.sort(key=lambda x: (len(x), get_sum(x), x))
    print(*serial, sep='\n')
