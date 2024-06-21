# https://school.programmers.co.kr/learn/courses/30/lessons/258712

def solution(friends, gifts):
    answer = 0
    # 선물 기록이 있다면, 더 많은 선물을 준 사람이 선물 받음
    # 선물 기록이 없거나 같다면, 선물 지수가 더 큰사람이 받는다.
    # 선물 지수 : 이번 달까지 자신이 친구들에게 준 선물의 수 - 받은 선물의 수
    # 만약 선물 지수도 같다면, 선물을 주고받지 않는다.
    # gifts : A != B
    # 다음 달에 가장 선물을 많이 받는 사람의 받은 선물 수는?
    gift_history = dict()
    gift_level = dict()
    give = dict()
    # Init
    for friend in friends:
        gift_history[friend] = dict()
        for other in friends:
            if friend != other:
                gift_history[friend][other] = 0
        gift_level[friend] = 0
        give[friend] = 0
    for gift in gifts:
        _from, _to = gift.split(" ")
        if _to in gift_history[_from]:
            gift_history[_from][_to] += 1
        # 선물 지수 계산
        gift_level[_from] += 1
        gift_level[_to] -= 1
    
    # Solve
    for me in gift_history:
        for other in gift_history[me]:
            # 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면
            if gift_history[me][other] == gift_history[other][me]:
                # 나의 선물 지수가 더 큰 경우만 고려
                if gift_level[me] > gift_level[other]:
                    give[me] += 1
            # 선물을 준 기록이 있는 경우
            elif gift_history[me][other] > 0:
                # me와 other가 서로에게 준 선물 수 비교
                if gift_history[me][other] > gift_history[other][me]:
                    give[me] += 1
    print(give)
    answer = max(give.values())
    return answer
