from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    temp = {
        1: "I", 2: "II", 3: "III", 4: "IV",
        5: "V", 6: "VI", 7: "VII", 8: "VIII",
        9: "IX", 10: "X", 11: "XI", 12: "XII"
    }
    N = int(input())
    S = input()

    # Solve
    res = ''
    for i in range(1, 13):
        if temp[i] in S:
            res += str(i) + ' '
    
    # Output
    print(res)
