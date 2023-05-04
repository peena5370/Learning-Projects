@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class DemoControllerTest {

  @InjectMocks
  private DemoController demoController;

  @Mock
  private DemoService demoService;

  @Test
  void createWhenSuccess() throws Exception {
    // Setup mocked object
    Demo demo = new Demo(1, "demo string");

    // when
    when(demoService.createDemo(any(Demo.class))).thenReturn("success");

    // execute
    ResponseEntity<String> responseEntity = demoController.create(demo);

    // result
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(responseEntity.getBody()).isEqualTo("success");
  }

  @Test
  void readAll() throws Exception {
    // setup mocked object
    Demo demo1 = new Demo(1, "demo string 1");
    Demo demo2 = new Demo(2, "demo string 2");

    // when
    when(demoService.getAll()).thenReturn(org.assertj.core.util.Lists.newArrayList(demo1, demo2));

    // execute
    ResponseEntity<List<Demo>> responseEntity = demoController.readList();

    // result
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntity.getBody().size()).isEqualTo(2);
    assertThat(responseEntity.get(0).getDescription()).isEqualTo(demo1.getDescription());
    assertThat(responseEntity.get(1).getDescription()).isEqualTo(demo2.getDescription());
  }

  @Test
  void updateWhenSuccess() throws Exception {
    // setup mocked object
    Demo demo1 = new Demo(1, "demo string 1");

    // when
    when(demoService.updateById(any())).thenReturn("success");

    // execute
    ResponseEntity<String> responseEntity = demoController.update(demo1);

    // result
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntity.getBody()).isEqualTo("success");
  }

  @Test
  void deleteWhenSuccess() throws Exception {
    // setup mocked object
    Demo demo1 = new Demo(1, "demo string 1");

    // when
    when(demoService.deleteById(demo.getId())).thenReturn("success");

    // execute
    ResponseEntity<String> responseEntity = demoController.delete(demo1.getId());

    // result
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntity.getBody()).isEqualTo("success");
  }
}
