if __name__ == '__main__':
    # Input
    N, K = map(int, input().split())
    S = [*input()]

    # Solve
    answer = 0
    for i in range(N):
        if S[i] == 'P':
            for j in range(max(0, i - K), min(N, i + K + 1)):
                if S[j] == 'H':
                    S[j] = '-'
                    answer += 1
                    break

    # Output
    print(answer)