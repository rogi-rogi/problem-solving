from sys import stdin
input = stdin.readline

def bf_command(idx) :
    global ptr
    ch = line[idx]
    if ch == '>' : ptr = [ptr + 1, 0][ptr == 32767]
    elif ch == '<' : ptr = [ptr - 1, 0][ptr == 0]
    elif ch == '+' : arr[ptr] = [arr[ptr] + 1, 0][arr[ptr] == 255]
    elif ch == '-' : arr[ptr] = [arr[ptr] - 1, 255][arr[ptr] == 0]
    elif ch == '.' : res.append(chr(arr[ptr]))
    elif ch == '[' and arr[ptr] == 0 : idx = jump[idx]
    elif ch == ']' and arr[ptr] != 0 : idx = jump[idx]
    return idx + 1
    
if __name__ == "__main__" :
    for i in range(int(input())) :
        arr = [0] * 32768
        ptr = 0
        res = [f"PROGRAM #{i + 1}:\n"]
        buff = []
        jump = dict()
        while True :
            line = input().replace(' ', '').rstrip()
            if line == "end" : break
            idx = line.find('%')
            buff.append([line, line[:idx]][idx != -1])
        line = ''.join(buff)
        temp = []
        for idx1, ch in enumerate(line) :
            if ch == '[' : temp.append(idx1)
            elif ch == ']' :
                idx2 = temp.pop()
                jump[idx1], jump[idx2] = idx2, idx1
        if temp : res.append("COMPILE ERROR")
        else :
            line_idx, end = 0, len(line)
            while line_idx < end : line_idx = bf_command(line_idx)
        print(*res, sep = '')
