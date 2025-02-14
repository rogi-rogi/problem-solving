from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())

    # Solve
    n = N
    while n > 0:
        # Output
        str1 = str(n) + [' bottles', ' bottle'][n == 1]
        str2 = [str(n - 1) + [' bottles', ' bottle'][n == 2], 'no more bottles'][n == 1]
        print("%s of beer on the wall, %s of beer." % (str1, str1))
        print("Take one down and pass it around, %s of beer on the wall." % str2)
        print()
        n -= 1
    print("No more bottles of beer on the wall, no more bottles of beer.")
    print("Go to the store and buy some more, %s of beer on the wall." % (str(N) + [' bottles', ' bottle'][N == 1]))
