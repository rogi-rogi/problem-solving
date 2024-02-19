-- 12세 이하인 여자 환자 목록 출력하기.sql
-- https://school.programmers.co.kr/learn/courses/30/lessons/132201

SELECT PT_NAME, PT_NO, GEND_CD, AGE, COALESCE(TLNO, "NONE") AS TLNO 
FROM PATIENT AS P
WHERE P.GEND_CD = 'W' AND P.AGE <= 12 
ORDER BY P.AGE DESC, P.PT_NAME;
