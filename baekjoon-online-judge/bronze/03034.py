N, W, H = map(int, input().split())
print('\n'.join(["NE", "DA"][int(input()) <= int(pow(W ** 2 + H ** 2, 0.5))] for _ in range(N))) 
