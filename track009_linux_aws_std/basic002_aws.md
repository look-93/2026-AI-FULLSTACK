## Part002. AWS

■ Step0. 회원가입 / 로그인
■ Step1. EC2

1. 인스턴스생성
2. public ip 주소 > 3.39.195.166
3. ssh 클라이언트

- 연결
- ssh 클라이언트 내부
- 퍼블릭 dns

    > ssh -i "the703.pem" ubuntu@ec2-3-39-195-166.ap-northeast-2.compute.amazonaws.com
    > yes
    - 리눅스 연결됨

※ .pem 보관주의

```bash
chmod 400 "the703.pem" # 소유자(4: r--) 그룹(0:---) 다른사람(0: ---)
```

- ctrl + `

```
# 1. 상속 권한 완전히 제거
icacls ".pem" /inheritance:r /grant:r "$($env:USERNAME):(R)"

# 2. 혹시 남아있을 수 있는 다른 사용자 권한 강제 삭제
icacls ".pem" /remove "NT AUTHORITY\Authenticated Users"
icacls ".pem" /remove "BUILTIN\Users"
icacls ".pem" /remove "NT AUTHORITY\SYSTEM"
```

■4. EC2에서 nginx

- 웹서버연결
- back와 front 연결설정

1. nginx 설치

```
sudo apt update
sudo apt install  nginx  -y
```

2. nginx 설정파일 수정

2-1.

```
sudo vi   /etc/nginx/sites-available/default
```

2-2. esc 눌러서 명령모드로 전환
2-3. :%d 입력한뒤에 enter → 전체삭제
2-4. i 눌러서 입력모드전환 → 붙여넣기
2-5. esc → :wq! 저장후 종료

```


server {
    listen 80;
    server_name 3.39.195.166;

    # 프론트엔드 (Next.js SSR 서버)
    location / {
        proxy_pass http://localhost:3000;
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection "upgrade";
        proxy_set_header Host $host;
        proxy_cache_bypass $http_upgrade;
        proxy_set_header Cookie $http_cookie;
    }

    # 백엔드 - 유저 인증 (/auth)
    location /auth {
        proxy_pass http://localhost:8080;
        proxy_http_version 1.1;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header Cookie $http_cookie;
    }

    # 백엔드 - 일반 API (/api)
    location /api {
        proxy_pass http://localhost:8080;
        proxy_http_version 1.1;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header Cookie $http_cookie;
    }

    # 백엔드 - 소셜 로그인 (/oauth2)
    location /oauth2 {
        proxy_pass http://localhost:8080;
        proxy_http_version 1.1;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header Cookie $http_cookie;
    }

    # 백엔드 - 카카오/구글 리다이렉트 처리
    location /login/oauth2/ {
        proxy_pass http://localhost:8080;
        proxy_http_version 1.1;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
    }

    # 프론트엔드에서 처리해야 하는 콜백
    location /oauth2/callback {
        proxy_pass http://localhost:3000;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header Cookie $http_cookie;
    }

    # 정적 파일 경로
    location /uploads/ {
        alias /home/ubuntu/app/back/build/libs/uploads/;
        autoindex off;
    }
}


```

설명)
location / { ← /여기경로로
proxy_pass http://localhost:3000; ← 포트번호 3000번호
proxy_http_version 1.1; ← 통신시 http
proxy_set_header Upgrade $http_upgrade; ← 헤더 그대로 전달
proxy_set_header Connection "upgrade"; ← 헤더 강제 설정
proxy_set_header Host $host; ← host 백엔드로 전송
proxy_cache_bypass $http_upgrade; ← 연결시 캐시 사용안함.
proxy_set_header Cookie $http_cookie; ← 쿠키백엔드 서버로 전달
}

3. nginx 실행 및 테스트

```
sudo nginx -t
sudo systemctl restart nginx
```

5. ECT 리포지토리

- 애플리케이션을 docker 이미지로 빌드해서 ecr에 올려두면 어디서든지 가져다가 사용가능하게

※ ecr 검색 (Elastic Container Registry)

0. 리포지토리생성
1. 리포지토리이름
2. 이미지 태그설정 - Mutable(연습용-latest 덮어쓸 수 있음)
3. 암호화설정 - 기본키 그대로

```
URI
974720436510.dkr.ecr.ap-northeast-2.amazonaws.com/the703
```

6. 필수 패키지 설정

1) 시스템 업데이트

```
sudo apt update && sudo apt upgrade -y
```

2. java 17 설치

```
sudo apt install openjdk-17-jdk -y
java -version
```

3. git 설치

```
sudo apt install git -y
```

4. docker 설치

```bash
sudo apt install docker.io -y
sudo systemctl enable docker && sudo systemctl start docker
sudo usermod -aG docker $USER
#    사용자계정 시스템그룹 docker
#  (ubuntu@ip-172-31-41-15:~$)
# 현재 로그인한 사용자에게 docker 그룹권한 sudo 없이 docker 명령어 사용가능
```

5. node.js & npm 설치

```
curl -fsSL https://deb.nodesource.com/setup_24.x | sudo -E bash -
sudo apt install -y nodejs
```

6. pm2 설치

```
sudo npm install -g pm2
```

7. nginx 설치 (위에서 설치)

```
sudo apt install nginx -y
```

8. 실행디렉토리 생성

```bash
#1. 상위폴더 및 uploads 폴더까지 한번에 생성 (-p 옵션)
mkdir -p /home/ubuntu/app/back/build/libs/uploads

#2. 홈 프로젝트 기본디렉토리 권한설정 (소유자-모든권한 rwx, 그룹/타인-읽기,실행 r-x)
sudo chmod 755 /home/ubuntu
sudo chmod 755 /home/ubuntu/app
sudo chmod 755 /home/ubuntu/app/back/build/libs/uploads
sudo chmod 644 /home/ubuntu/app/back/build/libs/uploads/* #이미생성
```

9. swap

```bash
sudo fallocate -l 2G /swapfile
sudo chmod 600 /swapfile
sudo mkswap /swapfile
sudo swapon /swapfile
echo '/swapfile none swap sw 0 0' | sudo tee -a /etc/fstab
free -h

# sudo fallocate -l 2G /swapfile ← 2GB 파일생성
# sudo chmod 600 /swapfile ← 권한유저(r:읽기 w:쓰기 x:실행)
# sudo mkswap /swapfile ← 스왑초기화
# sudo swapon /swapfile ← 스왑활성화
# echo '/swapfile none swap sw 0 0' | sudo tee -a /etc/fstab ← 설정파일 끝에 추가
# free -h ← 메모리 확인
```

10. docker - oracle 컨테이너 실행 (pull, run, ps, start)

```
sudo docker run -d --name oracle-xe -p 1521:1521 -p 5500:5500 -e ORACLE_PASSWORD=1234 gvenzl/oracle-xe:18-slim
```

11. 접속확인

```bash
# 1. 오라클이 완전히 실행될 때까지 로그 확인
sudo docker logs -f oracle-xe | grep "DATABASE IS READY TO USE"

# ctrl + c 빠져나오기

# 2. system 계정으로 접속 (비밀번호 변경 반영)
sudo docker exec -it oracle-xe sqlplus system/1234@XE

# --- (이후 sqlplus 프롬프트 안에서 아래 명령어들을 한 줄씩 실행) ---
CREATE USER scott IDENTIFIED BY tiger;
GRANT CONNECT, RESOURCE TO scott;

CREATE USER boot IDENTIFIED BY react;
GRANT CONNECT, RESOURCE TO boot;
exit;

# 3. 새로 만든 scott 계정으로 접속 확인
sudo docker exec -it oracle-xe sqlplus boot/react@XE
```

12. docker - redis

```bash
sudo docker run -d --name redis   -p 6379:6379   --restart=always   redis:7
```

13. 컨테이너 상태확인

```
sudo docker ps
```

14. ping 테스트

```
sudo docker exec -it redis redis-cli ping
```

15. ec2 자체에서 자동 실행설정

```
 sudo docker update --restart=always oracle-xe
 sudo docker update --restart=always redis
```

7. IM 사용자/역할 생성

1) IAM 콘솔 → 사용자추가
2) 권한정책: `AmazonEC2FullAccess`, `AmazonECS_FullAccess`, `AmazonEC2ContainerRegistryFullAccess`
3) 보안자격증명 : access key / secret key 발급

- AWS 외부에서 실행되는 애플리케이션

```
   access key : #
   secret key : #
```

- .csv 파일 다운로드

4. github secrets에 저장

- `AmazonEC2FullAccess` → EC2 인스턴스 관리
- `AmazonECS_FullAccess` → ECS/Faragate 서비스관리
    > Github Actions, Jenkins 외부도구에서 빌드한 도커 이미지를 aws ecr에 올림
    > 자동배포해주는 권한 셋팅
- `AmazonEC2ContainerRegistryFullAccess` → Docker이미지를 푸시/풀 할수 있게. 레지스트리 접근

■ Step2. GITHUB

> CI/CD

1. CI : 지속적 통홥

- 공용저장소에 자주병합
- 자동빌드/테스트를 통해서 조기에 버그 발견

2. CD : 지속적 제공/배포

- 자동으로 프로덕션 환경에 배포

---

1. git repisitory 새로만들기

- https://github.com/look-93/track009_aws.git

2. Actions secrets and veriables 시크릿키설정

- github - settings - Security and quality - secrets and veriables - Actions - New repository secret 클릭

```
Name: EC2_HOST
Secret: 3.39.195.166

add secret

... 나머지 반복

```

```bash
# 현재 ec2 public ip ★
Name: EC2_HOST
Secret: 3.39.195.166

Name: EC2_USER
Secret: ubuntu

# .pem 파일의 내용을 그대로 붙여넣기
Name: EC2_SSH_KEY
Secret:

# I AM 발급받은 Access Key
Name: AWS_ACCESS_KEY_ID
Secret: #

# I AM 발급받은 Secret Key
Name: AWS_SECRET_ACCESS_KEY
Secret: #

Name: AWS_REGION
Secret: ap-northeast-2

# 계정 ID 12자 숫자
Name: AWS_ACCOUNT_ID
Secret: #

# ECR 저장소(리포지토리) 이름
Name: ECR_REPO
Secret: the703
```

```bash
Name: DB_USERNAME
Secret: boot

Name: DB_PASSWORD
Secret: react

Name: JWT_SECRET
Secret: #

Name: GOOGLE_CLIENT_ID
Secret: #

Name: GOOGLE_CLIENT_SECRET
Secret: #

Name: KAKAO_CLIENT_ID
Secret: #

Name: NAVER_CLIENT_ID
Secret: #

Name: NAVER_CLIENT_SECRET
Secret: #

# public ip
Name: NEXT_PUBLIC_API_BASE_URL
Secret: http://3.39.195.166
```

※ ssh 클라이언트 > ssh -i "the703.pem" ubuntu@ec2-3-39-195-166.ap-northeast-2.compute.amazonaws.com

1. public ip > 3.39.195.166
   access key : #
   secret key : #

---

■ Step3. 워크플로우 작성 및 프로젝트 올리기

```
thejoa703/ ← 깃허브 저장소 루트
├── .git ← Git 저장소 메타데이터
├── .gitignore ← 불필요한 파일 제외 설정
├── BACK/ ← 백엔드 (Spring Boot)
│ ├── src/ ← 소스 코드
│ ├── build.gradle ← Gradle 빌드 설정
│ └── ... ← 기타 설정/리소스
├── FRONT/ ← 프론트엔드 (React + Next.js)
│ ├── src/ ← 소스 코드
│ ├── package.json ← npm 의존성 관리
│ └── ... ← 기타 설정/리소스
└── .github/
└── workflows/
└── deploy.yml ← GitHub Actions 워크플로우 파일
```

1. back 수정
   application.yml
   application_oauth.yml

2. front 파일수정

- .env.production
- 이미지 파일 설정 (src) / oauth 설정 / 하드코딩 되어있는곳 수정

3. jar 파일

- back폴더 가서 실행

```
./gradlew clean build -x test --refresh-dependencies
```

- [back]-[build]-[libs] 안에 파일생성 확인

4. 빌드

```
git add .
git commit -m "test deploy-1"
git push origin main
```

5. 외부테스트
   http://3.39.195.166

```
오류시
1. ssh 접속
2. pm2 list
3. pm2 logs backend/frontend
```

---

■ Step4. HTTPS + DOMAIN

```

```
