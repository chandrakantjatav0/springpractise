//package online.food.ordering.system.configuration;
//
//import java.util.List;
//
//import org.apache.catalina.Server;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import io.swagger.annotations.Contact;
//import io.swagger.annotations.Info;
//import io.swagger.annotations.License;
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import io.swagger.v3.oas.annotations.security.SecurityScheme;
//import io.swagger.v3.oas.annotations.security.SecuritySchemes;
//import io.swagger.v3.oas.models.OpenAPI;
//
///**
// *
// * @author Rohit
// */
//
//@Configuration
//@OpenAPIDefinition(security = @SecurityRequirement(name = "Bearer Token"))
//@SecuritySchemes({
//		@SecurityScheme(name = "Bearer Token", type = SecuritySchemeType.HTTP, scheme = "Bearer", bearerFormat = "JWT")
//})
//@SecurityRequirement(name = "Bearer Token")
//public class SwaggerConfig{
//    
//	  @Bean
//	  public OpenAPI myOpenAPI() {
//		  Server localServer = new io.swagger.v3.oas.models.servers.Server();
//		  localServer.setUrl("http://localhost:8080/");
//		  localServer.setDescription("Server URL in Local environment");
//		  
//
//
//		  Contact contact = new Contact();
//		  contact.setemail("rohit@gmail.com");
//		  contact.setName("Rohit");
//		  contact.setUrl("https://www.vegies.com/");
//
//		  License mitLicense = new License().name("MIT License").url("https://www.vegies.com/licenses/mit/");
//
//		  Info info = new Info()
//				  .title("EMS- API's Documentation")
//				  .version("1.0")
//				  .contact(contact)
//				  .description("EMS- API's").termsOfService("https://www.vegies.com.com/privacy-policy")
//				  .license(mitLicense);
//
//	    return new OpenAPI().info(info).servers(List.of(mainServer,localServer));
//	  }
//}