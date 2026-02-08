students = [*range(1, 31)]
for _ in range(28) :
    students.remove(int(input()))
print(*students, sep = '\n')
