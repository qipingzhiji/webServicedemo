import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class CxfClient {
    public static void main(String[] args) {
        //axis2服务端地址
        String url = "http://localhost:8080/services/ZipKinService";
        //创建工厂
        final  JaxWsProxyFactoryBean sf =  new JaxWsProxyFactoryBean();
        //对工厂对象附加属性,服务端地址,客户端接口
        sf.setServiceClass(DemoServcieInterface.class);
        sf.setAddress(url);
        //通过工厂方法创建具体实现的实例,也就是上面定义的接口
        DemoServcieInterface demoServcieInterface = (DemoServcieInterface)sf.create();
        String result = demoServcieInterface.getDemoService("我是cxf开发的客户端");
        System.out.println(result);
    }
}
