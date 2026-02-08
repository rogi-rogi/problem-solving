from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    N = int(input())
    correct_answer = [input() for _ in range(N)]
    student_answer = [input() for _ in range(N)]

    # Solve
    cnt = 0
    for i in range(N):
        if correct_answer[i] == student_answer[i]:
            cnt += 1

    # Output
    print(cnt)
