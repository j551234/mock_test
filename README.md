###### tags: `spring`
## spring test

## junit 
在spring boot 例面提供 junit 環境，可輕易撰寫單元測試
EX:
```java=
@SpringBootTest
class SpringBootJunit5ApplicationTests {

    @Test
    void contextLoads() {
    }

}
```
* @Test
    測試注釋指示該公共無效方法它所附著可以作為一個測試用例。

* @Before(BeforeEach)
    Before注釋表示，該方法必須在類中的每個測試之前執行，以便執行測試某些必要的先決條件。

* @BeforeClass(BeforeAll)
    BeforeClass注釋指出這是附著在靜態方法必須執行一次並在類的所有測試之前。發生這種情況時一般是測試計算共享配置方法(如連接到數據庫)。

* @After(AfterEach)
    After 注釋指示，該方法在執行每項測試後執行(如執行每一個測試後重置某些變量，刪除臨時變量等)

* @AfterClass(AfterAll)
    當需要執行所有的測試在JUnit測試用例類後執行，AfterClass注解可以使用以清理建立方法，(從數據庫如斷開連接)。注意：附有此批注(類似於BeforeClass)的方法必須定義為靜態。

* @Ignore
    當想暫時禁用特定的測試執行可以使用忽略注釋。每個被注解為@Ignore的方法將不被執行。

---


## mockmvc
要來測試api服務，使用mockmvc偽造一個http請求，並測試返回的內容。
```java=

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private HelloController helloController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testNotNull() {
        Assertions.assertThat(helloController).isNotNull();
    }

    @Test
    public void testHello() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello/spring"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello, spring"));
    }
}

```


## mockito

與 JUnit 相比，Mockito 最適合用來測試包含依賴注入環節的程式，而這也是 JUnit 目前不支援的部分。

因為在 JUnit 單元測試狀況中，大多會直接使用實際物件，然而這無法真正模擬實際狀況在處理依賴注入時是否會與預期一樣，因此會需要 Mockito 做此種狀況的測試。

且 Mockito 強項在於，可以單獨測試 Service 類程式，不需要去注意那些繁瑣的模組類程式，非常適合在作最後整合測試時使用，相比 JUnit 來說更能模擬實際程式執行的狀況。

Ref:https://hackmd.io/@KaiChen/H1R5Nq5FI


## spy 跟 mock

@Mock 製造假物件，裡面方法及屬性皆為NULL，需自行定義呼叫方法時的回傳值。
        
@Spy 製造監聽物件，裡面方法及屬性皆為實際物件

Ref:https://matthung0807.blogspot.com/2018/08/mockito-mockspy.html

## fake  return 
* when(...) thenReturn(...)會在方法被呼叫前去回傳假造的回傳，若有真的方法(SPY)會去在呼叫原本的方法，所以在MOCK物件可使用when(...) thenReturn(...)沒有任何副作用

* doReturn(...) when(...) 不會去呼叫方法，不會檢查回傳格式，在SPY物件時建議使用。
 
Ref:http://sangsoonam.github.io/2019/02/04/mockito-doreturn-vs-thenreturn.html


## mock inject
對於依賴
可以用@InjectMocks宣告測試的物件
會自動引用＠Mock或@Spy的物件來建立自己自己的bean


跟＠Spybean 和 @Mockbean 會自動注入spring 建成的物件
```java=
@WebMvcTest(GreetingController.class)
public class WebMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GreetingService service;

	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		when(service.greet()).thenReturn("Hello, Mock");
		this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, Mock")));
	}
}

```


Ref:https://matthung0807.blogspot.com/2018/08/mockito-mockinjectmocks.html
https://spring.io/guides/gs/testing-web/


## verify 
用來檢驗mock物件的方法是某被調用
```java=
    @Test
    void testMock() {
        when(testman.getName()).thenReturn("james");
        assert (testman.getName().equals("james"));
        
        verify(testman, times(1)).getName();


    }
```

Ref:https://www.baeldung.com/mockito-verify
