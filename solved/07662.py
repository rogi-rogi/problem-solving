from heapq import heappush, heappop
from sys import stdin
input = stdin.readline

def compareHeapAndPop(heap) :
    while heap and not isNull[heap[0][1]] : heappop(heap)
    
if __name__ == "__main__" :
    for _ in range(int(input())) :
        min_Q = []
        max_Q = []
        K = int(input())
        isNull = [False] * K
        for i in range(K) :
            instruction, num = input().split()
            num = int(num)
            if instruction == "I" : 
                heappush(min_Q, (num, i))
                heappush(max_Q, (-num, i))
                isNull[i] = True
            elif num == 1 :
                compareHeapAndPop(max_Q)
                if max_Q :
                    isNull[max_Q[0][1]] = False
                    heappop(max_Q)
            else : 
                compareHeapAndPop(min_Q)
                if min_Q :
                    isNull[min_Q[0][1]] = False
                    heappop(min_Q)
        compareHeapAndPop(min_Q)
        compareHeapAndPop(max_Q)
        if min_Q and max_Q :
            print(-heappop(max_Q)[0], heappop(min_Q)[0])
        else : print("EMPTY")
