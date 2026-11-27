from sys import stdin

input = stdin.readline

if __name__ == '__main__':

    # Input
    people = []

    for _ in range(int(input())):
        age, height = input().split()
        people.append((int(age), float(height)))

    answer = []

    # Solve
    people.sort(key=lambda x: (-x[0], -x[1]))

    for age, height in people:
        answer.append(f"{age} {height:.1f}")

    answer.append("")

    people.sort(key=lambda x: (x[1], x[0]))

    for age, height in people:
        answer.append(f"{age} {height:.1f}")

    # Output
    print(*answer, sep='\n')