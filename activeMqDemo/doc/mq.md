**参考文档**  [cnblogs:activemq的概念及基本用法](https://www.cnblogs.com/jaycekon/p/6225058.html)  
[activeMq的使用场景](https://www.cnblogs.com/shamo89/p/8010660.html)
## activeMq的基本特性：  
1. 多种语言和协议编写客户端。语言: Java, C, C++, C#, Ruby, Perl, Python, PHP。应用协议: OpenWire,Stomp REST,WS Notification,XMPP,AMQP
2. 完全支持JMS1.1和J2EE 1.4规范 (持久化,XA消息,事务)
3. 对Spring的支持,ActiveMQ可以很容易内嵌到使用Spring的系统里面去,而且也支持Spring2.0的特性
4. 通过了常见J2EE服务器(如 Geronimo,JBoss 4, GlassFish,WebLogic)的测试,其中通过JCA 1.5 resource adaptors的配置,可以让ActiveMQ可以自动的部署到任何兼容J2EE 1.4 商业服务器上
5. 支持多种传送协议:in-VM,TCP,SSL,NIO,UDP,JGroups,JXTA
6. 支持通过JDBC和journal提供高速的消息持久化
7. 从设计上保证了高性能的集群,客户端-服务器,点对点
8. 支持Ajax
9. 支持与Axis的整合
10.可以很容易得调用内嵌JMS provider,进行测试  
## activeMq的使用场景  
1. 异步处理  
2. 应用解耦
3. 流量销峰
4. 消息通讯

