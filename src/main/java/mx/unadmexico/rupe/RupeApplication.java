package mx.unadmexico.rupe;

import static org.springframework.boot.SpringApplication.run;
import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
@Slf4j
public class RupeApplication {

  public static void main(String[] args) {
    run(RupeApplication.class, args);
    log.info("\n\033[0;92mRUPE started!\u001B[0m");
  }
}
