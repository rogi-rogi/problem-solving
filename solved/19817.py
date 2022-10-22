'''
합병하려는 임의의 두 회사(company1, company2)에 대해 각 회사별 직원들 중 최대 급여를 max_m1, max_m2라고 하자.(max_m1 >= max_m2)
두 최대 급여가 동일시 되도록 두 최대 급여의 차이만큼, 회사(company2)의 전 직원 급여를 인상하면 된다.
따라서, 회사의 인원과 인원별 급여를 입력받을 때 (직원들 중 최대급여, 직원의 수) 형식으로 최대 힙에 저장해 풀이할 수 있다.
'''

import heapq
from sys import stdin
input = stdin.readline

result = 0
heap = []
for i in range(int(input())) :
    company = list(map(int, input().split()))
    heapq.heappush(heap, (-max(company[1:]), company[0]))
while len(heap) > 1 :
    max_m1, M1 = heapq.heappop(heap)
    max_m2, M2 = heapq.heappop(heap)
    result += (max_m2 - max_m1) * M2
    heapq.heappush(heap, (max_m1, M1 + M2))
print(result)
