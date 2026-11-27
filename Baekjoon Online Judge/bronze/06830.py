from sys import stdin
input = stdin.readline

if __name__ == '__main__':
    # Input
    city, temp = "", 201
    try:
        while True:
            c, t = input().split()
            t = int(t)
            # Solve
            if t < temp:
                city = c
                temp = t
    except:
        # Output
        print(city)
        
