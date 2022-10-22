grade = [int(input()) for _ in range(6)]
print(sum(sorted(grade[:4])[::-1][:3]) + max(grade[4:]))
