SPLIT = ')'

def stack_push(stack, num):
    if stack and stack[-1] != SPLIT:
        stack[-1] += num
    else:
        stack.append(num)

if __name__ == '__main__':
    S = input()
    i = len(S) - 1
    stack = []
    res = 0
    while i >= 0:
        if S[i] == '(':
            kq = int(S[i - 1]) * stack[-1] # K * len(Q)
            stack.pop() # delete stack[-1]
            stack.pop() # delete ')'
            stack_push(stack, kq)
            i -= 1      # jump to 'K'
        elif S[i] == ')':
            stack.append(')')
        else:
            stack_push(stack, 1)
        i -= 1
    print(stack[0])
