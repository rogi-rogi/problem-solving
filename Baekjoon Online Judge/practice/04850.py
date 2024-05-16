while True:
    try:
        N, w, d, total = map(int, input().split())
        ans = (w * (N * (N - 1) / 2) - total) / d;
        print(int([ans, N][ans == 0]))
    except:
        break
