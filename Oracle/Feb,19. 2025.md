
# 2025/02/19
<br>

# 13. 뷰 (View)
<br>
 
## 1. 뷰의 개념
- **뷰(View)** : 물리적인 테이블을 근거로 한 논리적인 가상 테이블
- 가상 테이블이므로 **실제 데이터를 저장하지 않음**
- 기본 테이블에서 **파생된 쿼리 결과를 저장하는 객체**
- 사용자에게 제한된 데이터 접근을 제공

<br>
 
## 2. 뷰의 구조
- 뷰는 **기본 테이블을 기준으로 SELECT 쿼리를 저장**하는 형태
- `USER_VIEWS` 테이블에서 뷰의 구조 확인 가능

<br>
 
## 3. 뷰의 사용 이유
- 보안 (민감한 데이터 접근 제한)
- 복잡한 쿼리 간소화
- 데이터 무결성 유지

<br>
 
## 4. 뷰의 종류
- **단순 뷰(Simple View)** : 하나의 테이블 기반, DML 가능
- **복합 뷰(Complex View)** : 여러 테이블 조인, 그룹 함수 포함, DML 불가능

<br>
 
## 5. 뷰 삭제 및 옵션
- `DROP VIEW 뷰이름;`  
- `WITH CHECK OPTION`, `WITH READ ONLY` 등의 옵션 사용 가능

<br>
 
# 14. 시퀀스 (Sequence)

<br>
 
## 1. 시퀀스 개념
- 테이블 내 **유일한 숫자 자동 생성**을 위한 객체
- 기본 키(PK) 자동 증가 목적으로 사용

<br>
 
## 2. 시퀀스 데이터 딕셔너리
- `USER_SEQUENCES` 뷰를 통해 시퀀스 정보 확인 가능

<br>
 
## 3. CURRVAL, NEXTVAL
- `NEXTVAL` : 다음 시퀀스 값을 반환
- `CURRVAL` : 현재 시퀀스 값을 반환

<br>
 
## 4. 시퀀스 적용
- **기본 키(PK) 자동 생성** 시 활용
```sql
INSERT INTO EMP(EMPNO, ENAME) VALUES (EMP_SEQ.NEXTVAL, '홍길동');
```

<br>
 
## 5. 시퀀스 제거 및 수정
- 제거: `DROP SEQUENCE 시퀀스명;`
- 수정: `ALTER SEQUENCE 시퀀스명 INCREMENT BY 5;`


<br>
 

## 15. 인덱스 (Index)

<br>
 
## 1. 인덱스 개념
- **검색 성능 향상**을 위해 특정 컬럼에 생성하는 오라클 객체
- 테이블에서 특정 데이터를 빠르게 찾기 위해 사용

<br>
 
## 2. 인덱스 생성
```sql
CREATE INDEX IDX_EMP_ENAME ON EMP(ENAME);
```

<br>
 
## 3. 인덱스 제거
```sql
DROP INDEX IDX_EMP_ENAME;
```

<br>
 
## 4. 인덱스 사용 판단 기준
- **사용해야 하는 경우**
  - 테이블 행 수가 많을 때
  - WHERE 절에서 자주 사용하는 컬럼일 때
- **사용하지 말아야 하는 경우**
  - 테이블 행 수가 적을 때
  - DML(INSERT, UPDATE, DELETE)이 자주 발생할 때

<br>
 
## 5. 인덱스 종류
- **고유 인덱스(Unique Index)** : 중복 불가, 기본 키나 유일 키
- **비고유 인덱스(Non-Unique Index)** : 중복 허용, 검색 속도 향상
- **결합 인덱스(Composite Index)** : 여러 컬럼을 결합하여 생성
- **함수 기반 인덱스(Function Based Index)** : 특정 연산을 포함한 인덱스

<br>
 
## 6. 인덱스 재생성
- **DELETE 후 재생성 필요**
```sql
ALTER INDEX IDX_EMP_ENAME REBUILD;
```

---

**참고:** 오라클에서 최적의 성능을 유지하기 위해서는 인덱스와 시퀀스를 적절히 활용하는 것이 중요합니다.
