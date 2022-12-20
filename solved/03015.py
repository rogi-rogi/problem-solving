'''
stack <= (height, 좌우로 자신과 쌍을 이룰 수 있는 사람의 수)
left : 자신보다 키가 작거나 같은 사람의 수
right : 자신의 바로 오른쪽 한 명
'''

from sys import stdin
input = stdin.readline

if __name__ == "__main__" :
    N = int(input())
    stack = [] 
    cnt = 0
    for h in [int(input()) for _ in range(N)] :
        while stack and stack[-1][0] < h :
            cnt += stack.pop()[1]
        if not stack :
            stack.append((h, 1))
        elif stack[-1][0] == h :
            sub_cnt = stack.pop()[1]
            if stack : cnt += 1
            stack.append((h, sub_cnt + 1))
            cnt += sub_cnt
        else :      # stack[-1][0] > h
            stack.append((h, 1))
            cnt += 1
    print(cnt)
