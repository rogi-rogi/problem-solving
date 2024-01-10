for TC in range(1, int(input()) + 1):
    input()
    count = [0] * 10
    for num in [*map(int, input())] :
        count[num] += 1
    
    maxIdx = 0
    maxNum = count[0]
    for idx, num in enumerate(count) :
        if num >= maxNum :
            maxNum = num
            maxIdx = idx
        
    print(f"#{TC} {maxIdx} {count[maxIdx]}")
