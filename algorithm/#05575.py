for _ in range(3) :
    fh, fm, fs, lh, lm, ls = map(int, input().split())
    t = (lm - fm) * 60 + (lh - fh) * 3600 + ls - fs
    print(t // 3600, (t % 3600) // 60, (t % 3600) % 60)
