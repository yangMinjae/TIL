# 2025/02/14

## 1. 관계형 데이터베이스 개요

### 관계형 데이터 모델
- 데이터를 테이블 형식으로 저장하고 관리하는 모델
- 테이블을 **릴레이션(Relation)** 이라고 부름

### 릴레이션(Relation)의 구성 요소
- **속성(Attribute)**: 테이블의 열(Column), 즉 필드
- **튜플(Tuple)**: 테이블의 행(Row), 즉 레코드
- **도메인(Domain)**: 속성이 가질 수 있는 값들의 집합
- **NULL 값**: 값이 정해지지 않았거나 존재하지 않는 경우

### 테이블(Table)
- **테이블 스키마(Table Schema)**: 테이블을 정의하는 구조 (R(A1, A2, ... An))
- **차수(Degree)**: 테이블의 속성 개수
- **기수(Cardinality)**: 테이블의 튜플 개수
- 테이블의 **레코드는 중복되지 않으며 순서가 없음**

### 키(Key)
- **슈퍼키(Super Key)**: 유일성을 가지지만 최소성을 만족하지 못하는 키
- **후보키(Candidate Key)**: 최소성을 만족하는 키
- **기본키(Primary Key)**: 후보키 중 한 개를 선택한 키, 중복/NULL 불가
- **외래키(Foreign Key)**: 다른 테이블의 기본키를 참조하는 키

## 2. SQL 기본 명령어

### 데이터 딕셔너리
- **TAB**: 사용자가 소유한 테이블 목록 조회
  ```sql
  SELECT * FROM TAB;
  ```
- **DESC**: 특정 테이블의 구조 확인
  ```sql
  DESC 테이블명;
  ```

### 데이터 타입
- **NUMBER(precision, scale)**: 숫자 저장, scale 생략 시 정수로 저장됨
- **DATE**: 날짜 및 시간 데이터 저장 (기본 형식: YY/MM/DD)
- **CHAR(n)**: 고정 길이 문자 데이터
- **VARCHAR2(n)**: 가변 길이 문자 데이터 (메모리 절약 가능)

### 데이터 조회 (SELECT)
- 테이블의 모든 컬럼 조회
  ```sql
  SELECT * FROM 테이블명;
  ```
- 특정 컬럼 조회
  ```sql
  SELECT 컬럼1, 컬럼2 FROM 테이블명;
  ```
- 별칭(Alias) 사용
  ```sql
  SELECT 컬럼명 AS 별칭 FROM 테이블명;
  ```
- 중복 제거
  ```sql
  SELECT DISTINCT 컬럼명 FROM 테이블명;
  ```

## 3. 데이터 필터링 및 연산

### WHERE 조건절
- 특정 조건을 만족하는 데이터만 조회
  ```sql
  SELECT * FROM 테이블명 WHERE 조건;
  ```
- **비교 연산자**
  ```sql
  =, >, <, >=, <=, <>, !=, ^=
  ```
- **논리 연산자**
  ```sql
  AND, OR, NOT
  ```
- **범위 조회 (BETWEEN AND)**
  ```sql
  SELECT * FROM 테이블명 WHERE 컬럼 BETWEEN 값1 AND 값2;
  ```
- **목록 조회 (IN 연산자)**
  ```sql
  SELECT * FROM 테이블명 WHERE 컬럼 IN (값1, 값2, 값3);
  ```
- **패턴 검색 (LIKE 연산자 및 와일드카드)**
  ```sql
  SELECT * FROM 테이블명 WHERE 컬럼 LIKE '김%'; -- '김'으로 시작하는 값 검색
  SELECT * FROM 테이블명 WHERE 컬럼 LIKE '%기%'; -- '기'를 포함하는 값 검색
  SELECT * FROM 테이블명 WHERE 컬럼 LIKE '_동_'; -- 두 번째 글자가 '동'인 값 검색
  ```
- **NULL 값 검색**
  ```sql
  SELECT * FROM 테이블명 WHERE 컬럼 IS NULL;
  SELECT * FROM 테이블명 WHERE 컬럼 IS NOT NULL;
  ```

## 4. 데이터 정렬 (ORDER BY)
- 오름차순 정렬 (기본값)
  ```sql
  SELECT * FROM 테이블명 ORDER BY 컬럼명 ASC;
  ```
- 내림차순 정렬
  ```sql
  SELECT * FROM 테이블명 ORDER BY 컬럼명 DESC;
  ```
- 여러 개의 정렬 조건 적용
  ```sql
  SELECT * FROM 테이블명 ORDER BY 컬럼1 DESC, 컬럼2 ASC;
  ```

