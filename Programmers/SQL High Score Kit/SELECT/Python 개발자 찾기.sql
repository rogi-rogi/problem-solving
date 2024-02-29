-- Python 개발자 찾기.sql
-- https://school.programmers.co.kr/learn/courses/30/lessons/276013

SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPER_INFOS
WHERE 'PYTHON' IN (SKILL_1, SKILL_2, SKILL_3) 
ORDER BY 1;
