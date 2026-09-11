package mx.unadmexico.rupe;

import static org.springframework.boot.SpringApplication.run;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RupeApplication {

  public static void main(String[] args) {
    run(RupeApplication.class, args);
    log.info("\n\033[0;92mRUPE started!\u001B[0m");
  }
}
