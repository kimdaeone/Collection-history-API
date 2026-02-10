# Collection-history-API
서비스의 실행 이력(수거)을 관리하기 위한 기초 REST API
[2026 Winter Vacation] Skill Level-Up Sprint Workflow

# ♻️ Collection History Management API
> **지속 가능한 자원 순환을 위한 수거 데이터 통합 관리 시스템**

폐기물 수거 물류 현장에서 발생하는 데이터를 디지털화하고, 데이터의 정합성을 보장하여 수거 효율을 높이기 위한 백엔드 서비스입니다.

---

## 1. 프로젝트 개요
- **배경**: 폐기물 수거 서비스 '업박스'의 핵심 데이터인 수거 이력을 안정적으로 처리하기 위한 기초 시스템 설계 역량 검증.
- **주요 기능**: 
- 수거 현장에서 발생하는 대량의 이력 데이터를 안정적으로 적재.
  - 잘못된 수거량 입력으로 인한 정산 오류를 시스템 차원에서 원천 방지.
  - 향후 모바일 앱 및 웹 대시보드와 유연하게 연동 가능한 RESTful 인터페이스 제공.

## 2. 기술 스택
- **Language**: Kotlin
- **Framework**: Spring Boot
- **Build Tool**: Gradle (Kotlin DSL)
- **Library**: Spring Web, Spring Boot Starter Validation

## 3. 핵심 설계 및 문제 해결

### ✅ 데이터 신뢰성 확보
- **문제**: 수량 입력 시 마이너스(-) 값이나 누락된 데이터가 발생할 경우, 통계 및 정산 데이터에 치명적인 오류를 초래함.
- **해결방법(?)**: `@field:Min(0)`과 `@field:NotBlank`를 활용한 서버 측 유효성 검증 계층을 구축하여, 유효한 데이터만 시스템에 유입되도록 제어함.

### ✅ 확장 가능한 아키텍처 (Layered Architecture)
- **설계 방향**: 현재는 빠른 프로토타이핑을 위해 메모리 기반 저장인 ArrayList를 사용하지만, 코드 수정 없이 데이터베이스(RDBMS) 전환이 가능하도록 인터페이스와 로직을 분리함.
- **DTO 패턴**: 내부 데이터 구조가 외부 API 스펙에 직접 노출되지 않도록 객체를 분리하여 캡슐화와 보안성 강화.

### ✅ Kotlin 기반 생산성 향상
- Kotlin의 `data class`를 활용해 불필요한 보일러플레이트 코드를 제거하고, 비즈니스 로직 자체에 더 집중할 수 있는 환경을 조성함.

## 4. API 가이드 및 테스트 결과
| 기능 | 방식 | 엔드포인트 | 기대 결과 |
| :--- | :--- | :--- | :--- |
| **전체 이력 조회** | `GET` | `/api/history` | 누적된 전체 수거 데이터 리스트 반환 |
| **신규 이력 등록** | `POST` | `/api/history` | 데이터 검증 후 성공 시 `201 Created` 반환 |
| **비정상 데이터 차단** | `POST` | `/api/history` | 음수 수거량 입력 시 에러 메시지 및 `400` 반환 |


## 📅 Development Roadmap
- [x] 1단계: 프로젝트 기획 및 환경 설정
- [x] 2단계: 데이터 구조(DTO) 및 유효성 검증 로직 설계
- [x] 3단계: 인메모리 저장소(Repository) 인터페이스 및 구현
- [x] 4단계: 비즈니스 로직(Service) 및 API 엔드포인트(Controller) 완성
- [ ] 5단계: API 기능 테스트 및 결과 문서화 (진행 중 🏃‍♂️)
- [ ] 6단계: 최종 코드 리팩토링 및 배포 준비

---
**Contact**: [ektlaksskgodqhrgo@gachon.ac.kr]
