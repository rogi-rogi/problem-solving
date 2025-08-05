from sys import stdin
input = stdin.readline

EMPTY = -1

if __name__ == "__main__" :
    N, K = map(int, input().split())
    nums = [*map(int, input().split())]
    res = 0
    plug = [EMPTY] * N
    for cur in range(K) :
        if nums[cur] in plug :
            continue
        for i in range(N) :
            if plug[i] == EMPTY :
                plug[i] = nums[cur]
                break
        else :
            long_enable = 0
            idx = 0
            for i in range(N) :
                time = 0
                for j in range(cur + 1, K) :
                    if plug[i] == nums[j] : break
                    time += 1
                if time > long_enable :
                    long_enable = time
                    idx = i
            plug[idx] = nums[cur]
            res += 1
    print(res)
