def solution(m, n, h, w, drops):
    rain_order = [[len(drops) + 1] * n for _ in range(m)]

    for order, (r, c) in enumerate(drops, 1):
        rain_order[r][c] = order

    def find_area(k):
        # k번 안에 비가 오는 칸의 누적합 2차원 배열
        prefix = [[0] * (n + 1) for _ in range(m + 1)]

        for r in range(m):
            row_sum = 0
            for c in range(n):
                if rain_order[r][c] <= k:
                    row_sum += 1
                prefix[r + 1][c + 1] = prefix[r][c + 1] + row_sum

        for r in range(m - h + 1):
            for c in range(n - w + 1):
                r2 = r + h
                c2 = c + w

                rain_count = (
                    prefix[r2][c2]
                    - prefix[r][c2]
                    - prefix[r2][c]
                    + prefix[r][c]
                )
                if rain_count == 0:
                    return (r, c)
        return None
    
    
    # find max rain order
    left = 0
    right = len(drops)

    while left < right:
        mid = (left + right + 1) // 2

        if find_area(mid) is not None:
            left = mid
        else:
            right = mid - 1

    return find_area(left)
