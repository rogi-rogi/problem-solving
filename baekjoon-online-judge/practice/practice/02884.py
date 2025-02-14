from sys import stdin
input=stdin.readline

# Input
H, M = map(int, input().split())

# Solve
if M < 45:
    H = (H + 23) % 24

# Output
print(f"{H} {(M + 15) % 60}\n")
