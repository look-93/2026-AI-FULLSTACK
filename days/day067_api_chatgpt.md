# ChatGpt
1. https://platform.openai.com/login
    - API Keys - create new secret key
    - Usage : 지출확인
        - 5달러까지 지원
    - billing 

2. application-oauth.properties
```
# ChatGpt
openai.api.key= 1번에서 발급받은 key

```

3. https://developers.openai.com/api/reference/resources/chat
```
curl https://api.openai.com/v1/chat/completions \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer $OPENAI_API_KEY" \
  -d '{
    "model": "VAR_chat_model_id",
    "messages": [
      {
        "role": "developer",
        "content": "You are a helpful assistant."
      },
      {
        "role": "user",
        "content": "Hello!"
      }
    ]
  }'


```

4. ApiOpenAi.java
    com.the7036.api


* 어떻게 연결했어요?
    - json 노드이용 해서 주소연결 client 값 세팅해서 json 파싱해서 가져왔습니다.


5. ApiUtilController.java
    - com.the703.controller
    ```
	////////////4. openai - gpt
	@Autowired ApiOpenAi apiOpenAi;
	
	
	@GetMapping("/openai")
	public String openai_get() {return "util/openai";}
	
	@PostMapping(value="/openai", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String openai_post(@RequestBody String content) {
		
		return apiOpenAi.getAIResponse("content");	
	}	

    ```

    6. view


# 사내규정집 챗봇

1. pom.xml
```
      <!-- Apache PDFBox -->
      <dependency>
          <groupId>org.apache.pdfbox</groupId>
          <artifactId>pdfbox</artifactId>
          <version>3.0.1</version>
      </dependency>
```
2. resources - docs - pdf파일넣기

3. LlmRagRequest.java
```
package com.the703.llmrag;

public class LlmRagRequest {

}

```

4. Message.java

```

package com.the703.llmrag;

import lombok.Value;

@Value
public class Message {
	String role;		// 역할
	String content;		// 질문
}

```
* @value
    - @Value로 한번에 통합
```
//@Getter 
//@FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE) - 모든필드를 private final 로 변경
//@AllArgsConstructor 
//@ToString 
//@EqualsAndHashCode 

```
5. LlmRagResponse.java

6. Choice.java

```
public record Choice(
		int index,
		Message message,
		String finish_reason
) {}

//record 

/* 
java 16버전 이상에서 사용
컴파일하면 자동으로 아래가 생성됩니다.

생성자(Constructor) ✅
Getter 역할 메서드 ✅
equals() ✅
hashCode() ✅
toString() ✅
*/


```

7. RestClientConfig.java
8. RagInitializer.java
9. AiService
10. controller
11. view