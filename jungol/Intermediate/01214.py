from sys import stdin

input = stdin.readline

if __name__ == '__main__':

    # Input
    _, *H = map(int, input().split())

    # Solve
    answer = 0
    H.append(0)
    stack = [] # idx, H[idx]

    for idx, height in enumerate(H):
        start_idx = idx

        while stack and stack[-1][1] > height: # prev_height > height
            prev_idx, prev_height = stack.pop()
            answer = max(answer, prev_height * (idx - prev_idx))
            start_idx = prev_idx
        stack.append((start_idx, height))

    # Output
    print(answer)