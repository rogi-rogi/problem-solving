K, D, A = map(int, input().split('/'))
print(['gosu', 'hasu'][D == 0 or K + A < D])
