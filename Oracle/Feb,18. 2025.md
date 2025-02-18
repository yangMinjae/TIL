# 2025/02/18
# 09. DDL
<br>

## 1. DDL (Data Definition Language)
DDL은 테이블과 같은 데이터 구조를 정의하는데 사용되는 언어로, 생성, 변경, 삭제, 이름 변경 등의 작업을 수행할 때 사용된다.

### 1.1 DDL 명령어 종류
| 명령어 | 설명 |
|--------|------|
| CREATE | 데이터베이스, 테이블 등을 생성 |
| ALTER | 테이블을 수정 |
| DROP | 데이터베이스, 테이블을 삭제 |
| TRUNCATE | 테이블을 초기화 |
<!-- 공백 유지용 -->
<br><br>

## 2. CREATE TABLE
테이블을 생성할 때 사용하는 명령어로, 컬럼의 이름, 데이터 타입, 제약조건 등을 설정할 수 있다.

```sql
CREATE TABLE 테이블명 (
    컬럼명1 데이터타입 제약조건,
    컬럼명2 데이터타입 제약조건
);
```
<br><br>

## 3. ALTER TABLE
기존 테이블의 구조를 변경할 때 사용된다.

### 3.1 컬럼 추가
```sql
ALTER TABLE 테이블명 ADD (컬럼명 데이터타입);
```

### 3.2 컬럼 수정
```sql
ALTER TABLE 테이블명 MODIFY (컬럼명 데이터타입);
```

### 3.3 컬럼 삭제
```sql
ALTER TABLE 테이블명 DROP COLUMN 컬럼명;
```
<br><br>

## 4. DROP TABLE
테이블을 삭제할 때 사용된다. 삭제 후에는 복구할 수 없다.
```sql
DROP TABLE 테이블명;
```
<br><br>

## 5. TRUNCATE
테이블의 모든 데이터를 삭제하고 초기화할 때 사용된다. 롤백이 불가능하다.
```sql
TRUNCATE TABLE 테이블명;
```
<br><br>

## 6. RENAME
테이블의 이름을 변경할 때 사용된다.
```sql
RENAME 기존_테이블명 TO 새로운_테이블명;
```
<br><br>

# 10. DML
<br>

## 1. DML (Data Manipulation Language)
DML은 테이블의 데이터를 조작하는 명령어로, 데이터를 검색, 삽입, 수정, 삭제하는 역할을 한다.

### 1.1 DML 명령어 종류
| 명령어 | 설명 |
|--------|------|
| SELECT | 데이터를 검색 |
| INSERT | 데이터를 추가 |
| UPDATE | 데이터를 수정 |
| DELETE | 데이터를 삭제 |
<!-- 공백 유지용 -->
<br><br>
## 2. INSERT
테이블에 데이터를 추가하는 명령어
```sql
INSERT INTO 테이블명 (컬럼1, 컬럼2) VALUES (값1, 값2);
```
<br><br>

## 3. UPDATE
기존 데이터를 수정하는 명령어
```sql
UPDATE 테이블명 SET 컬럼명 = 변경값 WHERE 조건;
```
<br><br>

## 4. DELETE
기존 데이터를 삭제하는 명령어
```sql
DELETE FROM 테이블명 WHERE 조건;
```
<br><br>

# 11. 트랜잭션
<br>

## 1. 트랜잭션 (Transaction)
트랜잭션은 데이터베이스에서 **하나의 논리적인 작업 단위**를 의미한다.

<br><br>

## 2. COMMIT과 ROLLBACK

### 2.1 COMMIT
트랜잭션을 완료하고 변경 내용을 **영구적으로 저장**한다.
```sql
COMMIT;
```

### 2.2 ROLLBACK
트랜잭션을 취소하고 변경 내용을 **원래 상태로 되돌린다**.
```sql
ROLLBACK;
```
<br><br>

## 3. SAVEPOINT
트랜잭션 내에서 특정 지점을 저장하고 해당 지점까지 롤백할 수 있도록 한다.
```sql
SAVEPOINT 저장지점명;
ROLLBACK TO 저장지점명;
```
<br><br>

# 12. 제약조건
<br>

## 1. 무결성 제약조건
제약조건은 **테이블의 데이터 무결성을 유지**하기 위해 설정된다.

### 1.1 제약조건 종류
| 제약조건 | 설명 |
|-----------|----------------------------------------------------|
| NOT NULL | NULL 값을 허용하지 않음 |
| UNIQUE | 중복된 값을 허용하지 않음 |
| PRIMARY KEY | NOT NULL + UNIQUE (기본 키 설정) |
| FOREIGN KEY | 다른 테이블의 PRIMARY KEY를 참조 |
| CHECK | 특정 조건을 만족하는 값만 허용 |
| DEFAULT | 기본값 설정 |
<!-- 공백 유지용 -->
<br><br>

## 2. 제약조건 설정 방법

### 2.1 컬럼 레벨 제약조건 설정
```sql
CREATE TABLE 테이블명 (
    컬럼명 데이터타입 CONSTRAINT 제약조건명 PRIMARY KEY,
    컬럼명 데이터타입 CONSTRAINT 제약조건명 UNIQUE,
    컬럼명 데이터타입 CONSTRAINT 제약조건명 CHECK(조건)
);
```

### 2.2 테이블 레벨 제약조건 설정
```sql
CREATE TABLE 테이블명 (
    컬럼명1 데이터타입,
    컬럼명2 데이터타입,
    CONSTRAINT 제약조건명 PRIMARY KEY (컬럼명1),
    CONSTRAINT 제약조건명 FOREIGN KEY (컬럼명2) REFERENCES 참조테이블(참조컬럼)
);
```
<br><br>

## 3. 제약조건 제거하기
```sql
ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명;
```