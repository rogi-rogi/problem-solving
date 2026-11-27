for _ in range(int(input())) :
    info = [*map(int, input().split())]
    total_section = sum(info[1:])
    res = info[1] >= 10.5 and info[2] >= 7.5 and info[3] >= 12 and total_section >= 55
    print(info[0], total_section, ["FAIL", "PASS"][res])
