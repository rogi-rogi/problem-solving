if __name__ == "__main__" :
    string = input()
    boom = input()
    boom_last_chr = boom[-1]
    len_boom = len(boom)
    stack = []
    for s in string :
        stack.append(s)
        if s == boom_last_chr and ''.join(stack[-len_boom:]) == boom :
            del stack[-len_boom:]
    print(''.join(stack) if stack else "FRULA")
