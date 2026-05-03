from collections import defaultdict

def solve():
    direction_freq = defaultdict(bool)

    for a in A:
        direction_freq[a] = True

    return (
        direction_freq["N"] == direction_freq["S"]
        and direction_freq["E"] == direction_freq["W"]
    )

if __name__ == '__main__':
    # Input
    answer = []
    for _ in range(int(input())):
        A = input()
        # Solve
        answer.append(["No", "Yes"][solve()])

    # Output
    print(*answer, sep='\n')