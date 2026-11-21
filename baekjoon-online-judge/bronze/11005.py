import string

if __name__ == '__main__':
    N, B = map(int, input().split())
    
    digits = '0123456789'+ string.ascii_uppercase
    calc = ''
    while N > 0:
        q, r = divmod(N, B)
        calc += digits[r]
        N = q
    answer = calc[::-1]
    
    print(answer)
