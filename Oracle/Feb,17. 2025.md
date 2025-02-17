# 2025/02/17

## 05. SQL 주요 함수
SQL에서 자주 사용되는 주요 함수들을 정리합니다.

### 1. 숫자 함수
- **ABS(n)**: 절대값 반환  
  ```sql
  SELECT ABS(-10) AS 절대값 FROM dual; -- 10 반환
  ```
- **FLOOR(n)**: 소수점 이하 버림  
  ```sql
  SELECT FLOOR(34.7) AS 버림 FROM dual; -- 34 반환
  ```
- **ROUND(n, d)**: 반올림  
  ```sql
  SELECT ROUND(34.5678, 2) AS 반올림 FROM dual; -- 34.57 반환
  ```
- **MOD(a, b)**: 나머지 반환  
  ```sql
  SELECT MOD(27, 5) AS 나머지 FROM dual; -- 2 반환
  ```

### 2. 문자 함수
- **UPPER(str)**: 대문자로 변환  
  ```sql
  SELECT UPPER('hello world') FROM dual; -- HELLO WORLD 반환
  ```
- **LOWER(str)**: 소문자로 변환  
  ```sql
  SELECT LOWER('HELLO WORLD') FROM dual; -- hello world 반환
  ```
- **SUBSTR(str, start, length)**: 부분 문자열 추출  
  ```sql
  SELECT SUBSTR('HELLO WORLD', 1, 5) FROM dual; -- HELLO 반환
  ```

### 3. 날짜 함수
- **SYSDATE**: 현재 날짜와 시간 반환  
  ```sql
  SELECT SYSDATE FROM dual;
  ```
- **MONTHS_BETWEEN(d1, d2)**: 두 날짜 간 개월 수 반환  
  ```sql
  SELECT MONTHS_BETWEEN(SYSDATE, TO_DATE('2024-01-01', 'YYYY-MM-DD')) FROM dual;
  ```
- **ADD_MONTHS(d, n)**: n개월 후 날짜 반환  
  ```sql
  SELECT ADD_MONTHS(SYSDATE, 3) FROM dual; -- 현재 날짜 기준 3개월 후 반환
  ```
- **LAST_DAY(d)**: 해당 월의 마지막 날짜 반환  
  ```sql
  SELECT LAST_DAY(SYSDATE) FROM dual;
  ```

---

## 06. 그룹 함수
그룹 함수는 여러 행을 하나의 그룹으로 묶어 연산합니다.

### 1. 기본 그룹 함수
- **SUM(col)**: 합계 반환  
  ```sql
  SELECT SUM(sal) FROM emp; -- 급여 총합
  ```
- **AVG(col)**: 평균 반환  
  ```sql
  SELECT AVG(sal) FROM emp; -- 평균 급여
  ```
- **COUNT(col)**: 개수 반환  
  ```sql
  SELECT COUNT(*) FROM emp; -- 총 사원 수
  ```

### 2. GROUP BY 절
특정 컬럼을 기준으로 데이터를 그룹화할 때 사용됩니다.  
```sql
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno;
```

### 3. HAVING 절
그룹화된 데이터에서 특정 조건을 만족하는 그룹만 선택할 때 사용됩니다.  
```sql
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno HAVING AVG(sal) > 5000;
```

---

## 07. 조인 (JOIN)
조인은 두 개 이상의 테이블을 결합하여 데이터를 조회하는 방법입니다.

### 1. 기본 조인 (Equi Join)
두 테이블에서 동일한 값을 가지는 컬럼을 기준으로 데이터를 결합합니다.  
```sql
SELECT e.ename, d.dname 
FROM emp e, dept d 
WHERE e.deptno = d.deptno;
```

### 2. 자체 조인 (Self Join)
같은 테이블을 조인하여 관계를 조회합니다.  
```sql
SELECT e1.ename AS 직원, e2.ename AS 관리자 
FROM emp e1 
JOIN emp e2 ON e1.mgr = e2.empno;
```

### 3. 외부 조인 (Outer Join)
조인 조건을 만족하지 않는 행도 포함합니다.  
```sql
SELECT e.ename, d.dname 
FROM emp e 
LEFT OUTER JOIN dept d ON e.deptno = d.deptno;
```

### 4. ANSI JOIN
ANSI 표준 조인 방식으로, `INNER JOIN`, `LEFT JOIN`, `RIGHT JOIN`, `FULL JOIN`을 포함합니다.  
```sql
SELECT e.ename, d.dname 
FROM emp e 
INNER JOIN dept d ON e.deptno = d.deptno;
```

---

## 08. 서브 쿼리 (Subquery)
쿼리 내부에 또 다른 SELECT 문을 포함하는 형태입니다.

### 1. 단일 행 서브 쿼리
하나의 값을 반환하는 서브쿼리입니다.  
```sql
SELECT ename, sal FROM emp WHERE sal = (SELECT MAX(sal) FROM emp);
```

### 2. 다중 행 서브 쿼리
여러 개의 값을 반환하는 서브쿼리로, **IN**, **ANY**, **ALL** 연산자를 사용합니다.  
```sql
SELECT ename, sal FROM emp WHERE deptno IN (SELECT deptno FROM dept WHERE loc = 'NEW YORK');
```

---

## 09. DDL (Data Definition Language)
DDL은 테이블 및 데이터 구조를 정의하는 SQL 명령어를 포함합니다.

### 1. 테이블 생성 (CREATE TABLE)
새로운 테이블을 생성할 때 사용됩니다.  
```sql
CREATE TABLE emp (
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR2(10),
    sal NUMBER(7,2),
    deptno NUMBER(2)
);
```

### 2. 테이블 수정 (ALTER TABLE)
기존 테이블 구조를 변경할 때 사용됩니다.  
```sql
ALTER TABLE emp ADD job VARCHAR2(20);
ALTER TABLE emp MODIFY sal NUMBER(10,2);
ALTER TABLE emp DROP COLUMN job;
```

### 3. 테이블 삭제 (DROP TABLE, TRUNCATE)
기존 테이블을 삭제하는 명령어입니다.  
```sql
DROP TABLE emp;
TRUNCATE TABLE emp;
```

### 4. RENAME
테이블 이름을 변경할 때 사용됩니다.  
```sql
RENAME emp TO employee;
```

### 5. 데이터 딕셔너리
DB에서 시스템이 관리하는 정보를 조회할 수 있는 테이블로, `USER_XXXX`, `ALL_XXXX`, `DBA_XXXX` 뷰가 포함됩니다.  
```sql
SELECT * FROM USER_TABLES;
SELECT * FROM ALL_OBJECTS WHERE OWNER = 'SCOTT';
SELECT * FROM DBA_USERS;
```
