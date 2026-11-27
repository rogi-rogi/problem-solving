if __name__ == '__main__':
    res = []

    # Solve
    for i in range(10, 100):
        for j in range(1, 10):
            for k in range(10, 100):
                x = i * 10 + j
                y = j * 100 + k
                if x / y == i / k and (x != y or i != k):
                    res.append(f"{x} / {y} = {i} / {k}")

    # Output
    print(*res, sep='\n')
    
