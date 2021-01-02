## MyBatis笔记

### 常用配置注意点
**关于数据库字段与实体类中字段不对等问题的解决:**
+ 可以在mapper配置文件中定义resultMap属性进行关联 
+ 直接在查询语句中使用别名。
+ mybatis还支持直接配置驼峰命名，在主配置文件的setting标签中`mapUnderscoreToCamelCase`为true。
****
**在主配置文件中定义别名后配置返回值和参数类型，可以直接用别名，且不区分大小写**
`<typeAliases>
   <typeAlias type="com.tzx.entity.User" alias="user"/>
 </typeAliases>`
****
**关于主配置文件中的`datasource`配置:**
+ POOLED 采用传统的javax.sql.DataSource规范中的连接池，mybatis中有针对规范的实现。
+ UNPOOLED 采用传统的获取连接的方式，虽然也实现Javax.sql.DataSource接口，但是没有使用池的思想。
+ JNDI 采用服务器提供的JNDI技术实现，来获取DataSource对象，不同的服务器所能拿到的DataSource对象是不一样的。

```datasource```**标签中的**`type属性就是表示采用何种连接池方式`。

****
**关于mybatis中事务的自动提交：**
    在openSession方法中有个参数为autoCommit，即为自动提交事务。
****

**关于mapper配置文件中的查询条件：**
+ \<if>标签可以用来判断后添加查询条件
    需要注意的是`test`属性中不能出现`<`符号，否则会报错，`<`可以使用`lt`代替，
    `<=`可以使用`lte`代替，`>`可以使用`gt`代替，`>=`可以使用`gte`代替。\
  使用此标签时候最好在条件加上`where 1 = 1`防止所有if判断都失败的情况下语句不完整无法执行。
+ \<where> 当有多个条件时可以在`<if>`标签外面套一层此标签，此时就不在需要写`where 1 = 1`
    这个条件了，mybatis会自动判断添加。
+ \<foreach> 遍历集合，可用于子查询，它的属性:\
        `collection`要遍历的集合\
        `open`代表语句的开始部分\
        `close`代表语句的结束部分\
        `item`代表遍历的集合的单个元素，生成的变量名\
        `sperator`代表分隔符
****
### 多表查询
表之间关系:\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`一对一`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`一对多`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`多对一`\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`多对多`