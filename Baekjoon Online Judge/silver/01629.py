from sys import stdin
input = stdin.readline

# def mul(cnt):
#     if cnt == 1:
#         return A % C
#     half_pow = mul(cnt // 2)
#     if cnt % 2 == 0:
#         return half_pow * half_pow % C
#     else:
#         return (half_pow * half_pow % C) * A % C


# if __name__ == '__main__':
#     # Input
#     A, B, C = map(int, input().split())

#     # Solve & Output
#     A %= C
#     print(mul(B))

print(pow(*map(int, input().split())))
