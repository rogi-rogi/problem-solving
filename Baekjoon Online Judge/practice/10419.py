if __name__ == '__main__':
    # Input
    for i in range(int(input())):
        d = int(input())
        
        # Solve
        for j in range(10001):
            if j + j**2 > d:
                
                # Output
                print(j-1)
                break
