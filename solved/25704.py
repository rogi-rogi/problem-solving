N = int(input())
P = int(input())
sales = [500, P//10, 2000, P//4]
sale = 0
for i in range([4, N // 5][N <= 20]) :
    sale = max(sale, sales[i])
print([0, P - sale][P - sale >= 0])
