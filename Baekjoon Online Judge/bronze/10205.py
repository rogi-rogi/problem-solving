if __name__ == '__main__':
    # Input
    for N in range(1, int(input()) + 1):
        # Solve
        H = int(input()) + sum(1 if i == 'c' else -1 for i in input())
        
        # Output
        print(f"Data Set {N}:\n{H}\n")