from sys import stdin

input = stdin.readline

if __name__ == '__main__':

    # Input
    meet_times = []
    for i in range(1, int(input()) + 1):
        S, E = map(int, input().split())
        meet_times.append((S, E - S, i))

    # Solve
    meet_times.sort(key=lambda x: (x[1], x[0]))

    answer = []
    for meet_time in meet_times:
        answer.append(meet_time[2])

    # Output
    print(*answer, sep='\n')