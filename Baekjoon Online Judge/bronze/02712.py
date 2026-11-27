table = {
    "kg" : (2.2046, "lb"),
    "lb" : (0.4536, "kg"),
    "l"  : (0.2642, "g"),
    "g"  : (3.7854, "l")
}
    
for _ in range(int(input())) :
    value, unit = input().split()
    temp = table[unit]
    print("%.4f %s" % (float(value)*temp[0], temp[1]))
