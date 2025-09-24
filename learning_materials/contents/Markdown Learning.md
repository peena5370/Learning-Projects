<!-- Source: https://www.runoob.com/markdown/md-tutorial.html -->
# Markdown Learning

### Heading

```markdown
# Heading 1

## Heading 2

### Heading 3

#### Heading 4

##### Heading 5

###### Heading 6
```

### Comment

```markdown
[comment]: <> (This is a comment, it will not be included)
[//]: # (This may be the most platform independent comment)
```

### Strike-through Text

```markdown
~~Strike through string.~~
```

Output:
~~Strike through string.~~

### Underline Text

```markdown
<u>Underline string.</u>
```

Output:
<u>Underline string.</u>

### Unordered List

```markdown
* list with ' * ' symbol
+ list with ' + ' symbol
- list with ' - ' symbol
```

Output:

* list with ' * ' symbol

+ list with ' + ' symbol

* list with ' - ' symbol


### Ordered List

```markdwon
1. list with '1.' tag  
   1.1. First inner list  
   1.2. Second inner list  

2. list tiwh '2.' tag  
   * First inner list  
   * Second inner list  
```

Output:

1. list with '1.' tag  
  1.1 First inner list  
  1.2 Second innerlist  

2. list tiwh '2.' tag  
   * First inner list  
   * Second inner list  

### Nested Area

```markdown
> __Outer area__  
> Outer area text...
> > __First Nested Area__  
> > First nested area text...
> > > __Second Nested Area__  
> > > Sedond nested area text... 
```

Output:
> __Outer area__  
> Outer area text...
> > __First Nested Area__  
> > First nested area text...
> > > __Second Nested Area__  
> > > Sedond nested area text...  

### Markdown Fenced Code Block

1. Javascript code block

```markdown
    ```javascript
    $(document).ready(function() {
        alert("Hello World!");
    });
    ```
```

Output:

```javascript
$(document).ready(function() {
    alert("Hello World!");
});
```

### Java code block

```markdown
    ```java
    package test.com.testmarkdown;

    import java.io.*;

    public class HelloWorld {
        public static void main(String[] args) {
            System.out.println("Hello World!");
        }
    }
    ```
```

Output:

```java
package test.com.testmarkdown;

import java.io.*;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

3. Python code block

```markdown
    ```python
    print('Hello World!')
    ```
```

Output:

```python
print('Hello World!')
```

### Hyperlink

```markdown
<!-- With link title -->
[Google](https://www.google.com/)
<!-- Without link title -->
<https://www.google.com/>
```

Output:  
[Google](https://www.google.com/)  
<https://www.google.com/>

### Image

```markdown
![img](https://www.runoob.com/wp-content/uploads/2019/03/md-flow.png)
![markdown](../Pictures/markdown-logo.png)
```

Output:  
![markdown](../Pictures/markdown-logo.png)

### List

```markdown
| Heading | Title |
| :------: | :------: |
| Text | Text |
```

Output:

| Heading | Title |
| :------: | :------: |
| Text | Text |

### Button

```markdown
Please press <kbd>Ctrl</kbd>+<kbd>Alt</kbd>+<kbd>Del</kbd> to restart the computer.
```

Output:

Please press <kbd>Ctrl</kbd>+<kbd>Alt</kbd>+<kbd>Del</kbd> to restart the computer.

### Methods

#### 1. 横向流程图源码格式

```markdown
    ```mermaid
    graph LR
    A[方形] -->B(圆角)
        B --> C{条件a}
        C -->|a=1| D[结果1]
        C -->|a=2| E[结果2]
        F[横向流程图]
    ```
```

#### 2. 竖向流程图源码格式

```markdown
    ```mermaid
    graph TD
    A[方形] --> B(圆角)
        B --> C{条件a}
        C --> |a=1| D[结果1]
        C --> |a=2| E[结果2]
        F[竖向流程图]
    ```
```

#### 3. 标准流程图源码格式

```markdown
    ```flow
    st=>start: 开始框
    op=>operation: 处理框
    cond=>condition: 判断框(是或否?)
    sub1=>subroutine: 子流程
    io=>inputoutput: 输入输出框
    e=>end: 结束框
    st->op->cond
    cond(yes)->io->e
    cond(no)->sub1(right)->op
    ```
```

#### 4. 标准流程图源码格式(横向)

```markdown
    ```flow
    st=>start: 开始框
    op=>operation: 处理框
    cond=>condition: 判断框(是或否?)
    sub1=>subroutine: 子流程
    io=>inputoutput: 输入输出框
    e=>end: 结束框
    st(right)->op(right)->cond
    cond(yes)->io(bottom)->e
    cond(no)->sub1(right)->op
    ```
```

#### 5. UML时序图源码样例

```markdown
    ```sequence
    对象A->对象B: 对象B你好吗?（请求）
    Note right of 对象B: 对象B的描述
    Note left of 对象A: 对象A的描述(提示)
    对象B-->对象A: 我很好(响应)
    对象A->对象B: 你真的好吗？
    ```
```

#### 6. UML时序图源码复杂样例

```markdown
    ```sequence
    Title: 标题：复杂使用
    对象A->对象B: 对象B你好吗?（请求）
    Note right of 对象B: 对象B的描述
    Note left of 对象A: 对象A的描述(提示)
    对象B-->对象A: 我很好(响应)
    对象B->小三: 你好吗
    小三-->>对象A: 对象B找我了
    对象A->对象B: 你真的好吗？
    Note over 小三,对象B: 我们是朋友
    participant C
    Note right of C: 没人陪我玩
    ```
```

#### 7. UML标准时序图样例

```markdown
    ```mermaid
    %% 时序图例子,-> 直线，-->虚线，->>实线箭头
    sequenceDiagram
        participant 张三
        participant 李四
        张三->王五: 王五你好吗？
        loop 健康检查
            王五->王五: 与疾病战斗
        end
        Note right of 王五: 合理 食物 <br/>看医生...
        李四-->>张三: 很好!
        王五->李四: 你怎么样?
        李四-->王五: 很好!
    ```
```

#### 8. 甘特图样例

```markdown
    ```mermaid
    %% 语法示例
            gantt
            dateFormat  YYYY-MM-DD
            title 软件开发甘特图
            section 设计
            需求                      :done,    des1, 2014-01-06,2014-01-08
            原型                      :active,  des2, 2014-01-09, 3d
            UI设计                     :         des3, after des2, 5d
        未来任务                     :         des4, after des3, 5d
            section 开发
            学习准备理解需求                      :crit, done, 2014-01-06,24h
            设计框架                             :crit, done, after des2, 2d
            开发                                 :crit, active, 3d
            未来任务                              :crit, 5d
            耍                                   :2d
            section 测试
            功能测试                              :active, a1, after des3, 3d
            压力测试                               :after a1  , 20h
            测试报告                               : 48h
    ```
```

Output:
![img](https://www.runoob.com/wp-content/uploads/2019/03/md-flow.png)

