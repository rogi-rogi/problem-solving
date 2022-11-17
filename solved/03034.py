N, W, H = map(int, input().split())
std = (W ** 2 + H ** 2) ** (1/2)
for _ in range(N) :
    print(["NE", "DA"][int(input()) <= std])
