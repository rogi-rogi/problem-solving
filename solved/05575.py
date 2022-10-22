for _ in range(3) :
    h1, m1, s1, h2, m2, s2 = map(int, input().split())
    t = (m2 - m1) * 60 + (h2 - h1) * 3600 + s2 - s1
    print(t // 3600, (t % 3600) // 60, (t % 3600) % 60)
