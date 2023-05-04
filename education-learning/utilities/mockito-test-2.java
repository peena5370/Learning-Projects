@RunWith(SpringRunner.class)
@WebMvcTest(value=DemoController.class,
            excludeAutoConfiguration={SecurityAutoConfiguration.class},
            excludeFilters=@ComponentScan.Filter(type=FilterType.REGEX, pattern="com.package.*.*Filter"))
public class DemoControllerTest {

  @InjectMocks
  private DemoController demoController;

  @MockBean
  private DemoService demoService;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  WebApplicationContext webApplicationContext;

  @Autowired
  private ObjectMapper objectMapper;

  @Before
  void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  void createWhenSuccess() throws Exception {
    // setup mocked object
    Demo demo = new Demo(1, "demo string 1");

    // when
    when(demoService.createDemo(any(Demo.class))).thenReturn("success");

    // execute and output result
    mockMvc.perform(MockMvcRequestBuilders.post("/demo/api/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("utf-8")
                    .content(objectMapper.writeValueAsString(demo)))
                    .andExpect(status().isCreated())
                    .andDo(print());
  }

  @Test
  void readAll() throws Exception {
    // setup mocked object
    Demo demo1 = new Demo(1, "demo string 1");
    Demo demo2 = new Demo(2, "demo string 2");

    // when
    when(demoService.getAll()).thenReturn(Lists.newArrayList(demo1, demo2));

    // execute and output result
    mockMvc.perform(MockMvcRequestBuilders.get("/demo/api/list")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$").isArray())
                    .andExpect(jsonPath("$[1].description").value(demo2.getDescription()))
                    .andExpect(jsonPath("$.length()").value(2))
                    .andDo(print());
  }

  @Test
  void updateWhenSuccess() throws Exception {
    // setup mocked object
    Demo demo1 = new Demo(1, "demo string 1");

    // when
    when(demoService.updateById(any())).thenReturn("success");

    // execute and output result
    mockMvc.perform(MockMvcRequestBuilders.put("/demo/api/update")
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("utf-8")
                    .content(objectMapper.writeValueAsString(demo1)))
                    .andExpect(status().isOk())
                    .andDo(print());
  }

  @Test
  void deleteWhenSuccess() throws Exception {
    // setup mocked object
    Demo demo1 = new Demo(1, "demo string 1");

    // when
    when(demoService.deleteById(demo.getId())).thenReturn("success");

    // execute and output result
    mockMvc.perform(MockMvcRequestBuilders.delete("/demo/api/delete")
                    .param("id", "1")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(print());
  }
}