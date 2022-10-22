n = int(input())
a = list(map(str, input().split()))
for i in range(n) :
    if a[i] != "mumble" and a[i] != str(i + 1) :
        print("something is fishy")
        exit(0)
print("makes sense")
