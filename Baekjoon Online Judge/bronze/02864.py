if __name__ == '__main__':
    A, B = input().split()
    res = [int(A.replace('6', '5')) + int(B.replace('6', '5')), int(A.replace('5', '6')) + int(B.replace('5', '6'))]
    print(*res)
