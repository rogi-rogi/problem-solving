from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    for _ in range(int(input())):
        a = int(input())
        b = int(input())
        
        # Solve & Output
        print(*divmod(a, b), sep='\n', end='\n\n')
