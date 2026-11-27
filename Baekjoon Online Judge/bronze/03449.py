from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    for _ in range(int(input())):
        str1 = input()
        str2 = input()

        # Solve
        cnt = sum(1 for i in range(len(str1)) if str1[i] != str2[i])

        # Output
        print(f'Hamming distance is {cnt}.')
