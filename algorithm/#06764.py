nums = [int(input()) for _ in range(4)]
if len(set(nums)) == 1 : print("Fish At Constant Depth")
else :
    std = 0
    for i in range(3) :
        if nums[i] < nums[i + 1] : std += 1
        elif nums[i] > nums[i + 1] : std -= 1
    if std == 3 : print("Fish Rising")
    elif std == -3 : print("Fish Diving")
    else : print("No Fish")
    
