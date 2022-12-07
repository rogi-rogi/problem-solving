'''
서로소 집합(Disjoint Set) 표현시 사용되는 알고리즘
parents       : 정점의 부모 노드의 번호를 담는 배열 (작은 번호를 기준)
find(v)       : 정점 v의 부모 노드를 탐색한다. (root node의 특성 이용, parent[root] == root)
union(v1, v2) : 정점 v1과 v2를 하나의 그래프로(부모노드를 동일하게) 연결한다.
  - root node가 같으면(v1 == v2) 이미 하나의 그래프이다.
  - root node를 번호가 작은 순으로 하기 때문에 v1, v2 중 큰 번호를 가진 노드를 병합시킨다. 

'''

class Disjoint-Set :
  def find(self, v, parents) :
    if parents[v] == v : return v
    parents[v] = self.find(parents[v], parents)
    return parents[v]
  
  def union(self, v1, v2, parents) :
    v1 = self.find(v1, parents)
    v2 = self.find(v2, parents)
    if v1 != v2 :
      parents[max(v1, v2)] = min(v1, v2)
      return True
    return False
