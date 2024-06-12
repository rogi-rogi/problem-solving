res = ""
for num in range(1, int(input()) + 1):
    if num % 3 == 0 and num % 5 == 0:
        res += "DeadMan\n"
    elif num % 3 == 0:
        res += "Dead\n"
    elif num % 5 == 0:
        res += "Man\n"
    else:
        res += str(num) + " "
print(res)
