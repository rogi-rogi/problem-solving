for _ in range(int(input())):
	X, Y, N = map(int, input().split())
	d = abs(X) + abs(Y)
	if d == N or (d < N and (d - N) % 2 == 0):
		print("YES")
	else:
		print("NO")
