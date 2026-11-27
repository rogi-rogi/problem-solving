if __name__ == '__main__' :
    S = input().rstrip()
    if S[0] == S[-1] == '"' and len(S) > 2:
        print(S[1:-1])
    else:
        print("CE")
