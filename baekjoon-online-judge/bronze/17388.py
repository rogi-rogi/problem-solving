S, K, H = map(int, input().split())
if S + K + H >= 100 : print("OK")
else : print({S:"Soongsil", K:"Korea", H:"Hanyang" }[min(S, K, H)])
