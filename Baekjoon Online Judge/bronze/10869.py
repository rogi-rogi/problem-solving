from sys import stdin
input=stdin.readline

# Input
A, B = map(int, input().split())

# Solve & Output
print(f"{A + B}\n{A - B}\n{A * B}\n{A // B}\n{A % B}\n")
