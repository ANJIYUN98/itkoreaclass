# 03_GIT_GITHUB
---
01 GIT 기본 개념
---
[수업자료]() |
[참고-SVN vs GIT](https://hahahoho5915.tistory.com/40) |
[참고]() |
- git 이란
- git 동작방식
- git 설치

---
02 GIT 기본 명령어
---
[수업자료]() |
[참고-명령어 정리](https://medium.com/@joongwon/git-git-%EB%AA%85%EB%A0%B9%EC%96%B4-%EC%A0%95%EB%A6%AC-c25b421ecdbd) |
[참고]() |
- 전역설정
  - git --global user.email "your email"
  - git --global user.name "your nickname"
  - git config - -global - -list 
- 기본 명령어
  - git init
  - git add
  - git commit  
- 확인 명령어
  - git log
  - git log --oneline 
- 되돌리기
  - git reset --soft
  - git reset --hard
  - git option
    - hard : 돌아간 커밋 이후의 변경 이력을 전부 삭제
    - soft : 변경 이력 삭제, 변경 내용은 남아있음, 인덱스 초기화(git add가 안되어 있는 상태)
    - mixed : 변경 이력 삭제, 변경 내용은 남이있음, 인덱스도 유지(git add까지 되어 있음) 
  - git reflog
  - git rm --cached filename (tracked file -> untracked file)

---
03 GIT 협업하기
---
[수업자료]() |
[참고-명령어 정리](https://medium.com/@joongwon/git-git-%EB%AA%85%EB%A0%B9%EC%96%B4-%EC%A0%95%EB%A6%AC-c25b421ecdbd) |
[참고]() |

- git branch | git switch
- git push | git pull  | git checkout
- git remote 
- git merge
    - 기본
    - 옵션(fast-forward merge / no fast-forward merge)
- conflict 해결(Confilct 무시 병합 | Conflict 해결 후 병합)

---
04 GITHUB 기본기능
---
[수업자료]() |
[참고-명령어 정리](https://medium.com/@joongwon/git-git-%EB%AA%85%EB%A0%B9%EC%96%B4-%EC%A0%95%EB%A6%AC-c25b421ecdbd) |
[참고-Branch Protect Rules](https://kotlinworld.com/292#google_vignette) | 
[참고-협업전략](https://hyeo-noo.tistory.com/393) | 
[참고]() |

- GIGHUB 기본 
- GIT -> GITHUB
- GITHUB -> GIT
- GITHUB BRANCH RULE
- GITHUB ISSUE
- GITHUB WORKFLOW(협업전략)

---
05 GITHUB 부가기능
---
[수업자료]() |
[참고-협업PROJECT/ISSUE사용하기](https://devlog-wjdrbs96.tistory.com/227) | [참고-GITHUB PAGE](https://docs.github.com/ko/pages)

- PROJECT / ISSUE / MILESTONE 
- GITHUB PAGE -> 개인포트폴리오 싸이트 경로 만들기
  

---
04 GIT GUI TOOLS
---
[수업자료]() |
[참고 - GUITools 순위](https://hosuappa.tistory.com/16) | 
[참고-깃크라켄01](https://raccoon42.tistory.com/39) | 
[참고-깃크라켄02](https://velog.io/@danna-lee/%EA%B0%9C%EB%B0%9C-%ED%98%91%EC%97%85%EC%97%90%EC%84%9C-%EA%B9%83-%EA%B9%83%ED%81%AC%EB%9D%BC%EC%BC%84-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0) | 

- 깃크라케 이란 
- 깃크라켄 기본 기능 사용하기
- 깃크라켄 협업 기능 사용하기

---
04 SLACK + GITHUB 연동
---
[수업자료]() |
[참고-SLACK 이란](https://m.blog.naver.com/webtool123/222073143022) |
[참고-SLACK 을 사용하는 이유](https://greypencil.tistory.com/145) |
[참고-SLACK + GITHUB PUSH 알림설정](https://itcreator.tistory.com/161)|

- SLACK 기본
- SLACK + GITHUB 연결하기

---
git/github으로 협업하기
---
[참고 - YOUTUBE 코딩 알려주는 누나](https://www.youtube.com/watch?v=tkkbYCajCjM)
