#heaqp ver
import heapq

if __name__ == '__main__':
    K, N = map(int, input().split())
    primes = list(map(int, input().split()))
    mols = list(primes) 
    heapq.heapify(mols)
    for _ in range(N):
        num = heapq.heappop(mols)
        for i in range(K):
            new_num = num * primes[i]
            heapq.heappush(mols, new_num)

            if num % primes[i] == 0:
                break
    print(num)
