if __name__ == '__main__':
    dancers = {"ChongChong"}
    
    for _ in range(int(input())):
        a, b = input().split()
        if a in dancers or b in dancers:
            dancers.add(a)
            dancers.add(b)
            
    print(len(dancers))
