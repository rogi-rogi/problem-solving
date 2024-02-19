-- 03(인기있는 아이스크림).sql
-- https://school.programmers.co.kr/learn/courses/30/lessons/133024
SELECT FLAVOR
FROM FIRST_HALF AS F
ORDER BY F.TOTAL_ORDER DESC, F.SHIPMENT_ID
