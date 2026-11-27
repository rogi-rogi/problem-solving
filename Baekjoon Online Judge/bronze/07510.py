for i in range(1, int(input()) + 1) :
    a, b, c = sorted([*map(int, input().split())])
    print(f"Scenario #{i}:")
    print(["no\n", "yes\n"][a**2 + b**2 == c**2])
