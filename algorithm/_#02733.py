from sys import stdin
input = stdin.readline

def bf_command(idx) :
    ch = arr[idx]
    if ch == '>' : ptr = [ptr + 1, 0][ptr == 32767]
    elif ch == '<' : ptr = [ptr - 1, 0][ptr == 0]
    elif ch == '+' : arr[ptr] = [arr[ptr] + 1, 0][ptr == 255]
    elif ch == '-' : arr[ptr] = [arr[ptr] - 1, 255][ptr == 0]
    elif ch == '.' : res.append(chr(arr[ptr]))
    elif ch == '[' : pass
    elif ch == ']' : pass
    return idx + 1
    
if __name__ == "__main__" :
    for i in range(int(input())) :
        arr = [0] * 32768
        ptr = 0
        res = ["PROGRAM #%d:" % (i + 1)]
        buff = []
        move = dict()
        while True :
            line = input().replace(' ', '')
            if line == "end" : break
            idx = line.find('%')
            buff.append([line, line[:idx]][idx != -1])
        line = ''.join(buff)
        temp = []
        for idx1, ch in enumerate(line) :
            if ch == '[' :
                temp.append(idx1)
            elif ch == ']' :
                idx2 = temp.pop()
                move[idx1], move[idx2] = idx2, idx1
        if temp : res.append("COMPILE ERROR")
        else :
            end = len(line)
            while line_idx < end : line_idx = bf_command(idx)
        print(*res, sep = '\n')
