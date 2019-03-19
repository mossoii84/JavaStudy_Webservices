package ru.javastudy.ws.main;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import ru.javastudy.ws.model.Goods;
import ru.javastudy.ws.soap.WebserviceSEI;

//Это клиенты, а сервер мы запустили(задеплоили, внедрили) в Томкат
public class JavaStudyWS {
    public static void main(String[] args) {
        testSOAPFromClient();
    }
    private static void testSOAPFromClient() {
        String soapServiceUrl = "http://localhost:8080/soap/webserviceSEI";

        //создаем экз класса Soap WebServ
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        //Soap Serv будет работать с методами SEI (наши интерфейсы в WebserviceSEI)
        factoryBean.setServiceClass(WebserviceSEI.class);
        //по какому адресу это soapService будет работать - soapServiceUrl = "http://localhost:8080/soap/webserviceSEI";
        factoryBean.setAddress(soapServiceUrl);

        // это заглушка - представляет endpoint на стороне клиента
        WebserviceSEI webserviceSEI = (WebserviceSEI) factoryBean.create();

        //итог клиенты вызвал у сервера метод getGoods
        Goods result = webserviceSEI.getGoods();
        String S= webserviceSEI.sayHelloTo("Привет");

        System.out.println("Result: " + result);
        System.out.println("Result: " + S);
    }
}
