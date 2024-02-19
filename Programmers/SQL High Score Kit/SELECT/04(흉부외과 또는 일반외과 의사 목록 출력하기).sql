-- 04(흉부외과 또는 일반외과 의사 목록 출력하기).sql
-- https://school.programmers.co.kr/learn/courses/30/lessons/132203

SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD
FROM DOCTOR AS D
WHERE D.MCDP_CD='CS' OR D.MCDP_CD='GS'
ORDER BY HIRE_YMD DESC, DR_NAME
