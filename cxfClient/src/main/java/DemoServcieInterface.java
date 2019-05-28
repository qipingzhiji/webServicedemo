import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * ZipKinService:webservice服务端提供的服务名-------->service.xml <service name="ZipKinService">
 * targetNamespace:对应webservice服务端wsdl?中的targetNamespace
 */
@WebService(name = "ZipKinService", targetNamespace = "http://webService.com")
public interface DemoServcieInterface {

    /**
     * CXF客户端本地接口调用端,参数param
     * @param test @WebMethod(operationName = "test")服务端方法名字,@WebParam(name = "param")参数名字
     * @return @WebResult客户端返回的结果类型--->String
     */
    @WebMethod(operationName = "test")
    @WebResult(targetNamespace = "http://webService.com")String getDemoService(@WebParam(name = "param", targetNamespace = "http://webService.com") String test);
}
