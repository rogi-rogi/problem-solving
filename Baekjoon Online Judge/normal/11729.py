from sys import stdin
input = stdin.readline

def hanoi(n, _from, _to, _tmp):
    if n == 1:
        print(_from, _to)
    else:
        hanoi(n - 1, _from, _tmp, _to)
        print(_from, _to)
        hanoi(n - 1, _tmp, _to, _from)

if __name__ == '__main__':
    # Input
    N = int(input())
    # Solve & Output
    print(int(pow(2, N)) - 1)
    hanoi(N, 1, 3, 2)
    
