from collections import defaultdict

def solve():
    direction_exists = defaultdict(bool)

    for a in A:
        direction_exists[a] = True

    return (
        direction_exists["N"] == direction_exists["S"]
        and direction_exists["E"] == direction_exists["W"]
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