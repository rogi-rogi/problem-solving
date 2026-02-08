from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    C = int(input())
    M = [*map(int, input().split())]
    if M[0] != 1 : # 첫 번째 항목의 번호가 1이 아니면, 올바른 보고서가 아니다.
        print(-1)
        exit(0)
    for num in M : # 번호가 항목의 개수보다 크다면, 올바른 보고서가 아니다.
        if num > C :
            print(-1)
            exit(0)
    visited = [0] * (C + 1)
    res = []
    before_num = 0
    for num in M :
        if num < before_num :
            # 현재 입력받은 수가 이전에 입력받은 수보다 작다면
            # 현재 입력받은 수보다 큰 수에 대해 초기화 진행.
            # for i in range(num + 1, C + 1) :
            #     visited[i] = 0
            visited[num] += 1
            res.append(visited[num])
        else : # 현재 입력받은 수가 이전에 입력받은 수보다 크거나 같다면, 방문 횟수를 누적
            if num > before_num : visited[num] = 0
            visited[num] += 1
            res.append(visited[num])
        before_num = num
    print(*res)
