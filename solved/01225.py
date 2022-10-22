A, B = map(list, input().split())
sum_b = sum(list(map(int, B)))
print(sum(i * sum_b for i in list(map(int, A))))
