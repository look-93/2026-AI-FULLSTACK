■ Step4. HTTPS + DOMAIN

1. DuckDns 도메인생성

- https://www.duckdns.org/
- 로그인
- sub domain → 원하는이름.duckdns.org → add domain
- ec2 public ip 연동 → current ip : public ip 업데이트
- Token 보관

```
 도메인명:#
 토큰:#
```

2. EC2 서버에서 DuckDns IP 자동 갱신설정

- aws ex2의 인스턴스를 중지했다 키면, 퍼블릭 ip 주소가 바뀜
    - ssh 접속
    - duckdns 폴더만들기

    ```bash
    sudo mkdir -p ~/duckdns
    cd ~/duckdns
    ```

    - duck.sh 쉘스크립트 작성

    ```bash
    sudo vi duck.sh
    esc , i
    esc, :wq!
    ```

    ```bash
    echo url="https://www.duckdns.org/update?domains=도메인명&token=복사해둔토큰&ip=" | curl -k -o ~/duckdns/duck.log -K -
    ```

    ※ -k : ssl/tls 인증서 건너 뛰기
    ※ -o ~/duckdns/duck.log : 성공 ok, 실패 ko
    ※ -K : 표준입력의 설정 : 코드 중간에 |(문자열) 있어도 curl 설정파일 형태로 읽어들이기
    - 실행권한주기 소유자(rwx) 그룹(x) 다른사람(x)

    ```sql
    sudo chmod 700 duck.sh
    crontab -e
    2

    */5 * * * * /home/ubuntu/duckdns/duck.sh >/dev/null 2>&1

    # 년 [월일 시분] 초 ← 읽는 방향(년초 빠지고)
    # 분   시 일 월 요일
    #  */5 * * * *

    # >/dev/null 화면에 안띄움
    # 2>&1 에러메시지 무시처리
    ```

    # crontab 작성 확인

    > crontab -l

3. Nginx 설정 변경

- 설정파일 수정

```
수정
sudo vi   /etc/nginx/sites-available/default

확인
sudo cat   /etc/nginx/sites-available/default

server {
    listen 80;
    server_name 3.39.195.166; ← 도메인명.duckdns.org

    ...#기존내용 그대로
}
```

- Nginx 재시작

```
sudo nginx -t
sudo systemctl restart nginx
```

4. Certbot 으로 https(SSL) 인증서 발급받기
    - certbot 설치

    ```bash
    sudo apt update
    sudo apt install snapd -y #격리된 환경
    sudo snap install core;
    sudo snap refresh core
    sudo snap install --classic certbot # certbot ssl무료 인증서 발급도구
    sudo ln -s /snap/bin/certbot /usr/bin/certbot # 터미널 어디서든지 certbot 사용가능
    ```

    - 인증서 발급 명령어

    ```bash
    # sudo certbot --nginx -d 도메인명.duckdns.org

    sudo certbot --nginx -d 도메인명.duckdns.org

    # email 입력 - 만료알림용 , 약관동의 y , 이메일수신 y, 리다이렉트 설정 2
    ```

5. 프로젝트 환경변수 및 설정 수정

    > https://bora-study.duckdns.org
    - boot: SecurityConfig, yml
    - react : .env

6. 소셜마무리

```

```
