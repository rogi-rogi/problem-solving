N = input()
print([0, 1][int(N) % 7 == 0] + [0, 2]['7' in N])
