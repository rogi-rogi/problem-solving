'''
서로소 집합(Disjoint Set) 표현시 사용되는 알고리즘
find(v)       : v의 부모 정점을 탐색한다. (root node의 특성 이용, parent[root] == root)
union(v1, v2) : v1과 v2를 하나의 그래프로 연결한다.
  - root node가 같으면(v1 == v2) 이미 하나의 그래프이다.
  - root node를 번호가 작은 순으로 하기 때문에 v1, v2 중 큰 번호를 가진 노드를 병합시킨다. 

'''

def find(v) :
  if parent[v] == v : return v
  parent[v] = find(parent[v])
  return parent[v]

def union(v1, v2) :
  v1 = find(v1)
  v2 = find(v2)
  if v1 != v2 :
    parent[max(v1, v2)] = min(v1, v2)
    return True
  return False

if __name__ == "__main__" :
  parent = [i for i in range(V + 1)]
