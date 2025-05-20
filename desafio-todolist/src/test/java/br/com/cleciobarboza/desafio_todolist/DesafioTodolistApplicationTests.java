package br.com.cleciobarboza.desafio_todolist;

import br.com.cleciobarboza.desafio_todolist.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(
   webEnvironment = WebEnvironment.RANDOM_PORT
)
class DesafioTodolistApplicationTests {
   @Autowired
   private WebTestClient webTestClient;

   DesafioTodolistApplicationTests() {
   }

   @Test
   void testCreateTodoSuccess() {
      Todo todo = new Todo("todo 1", "desc todo 1", false, 1);
      ((WebTestClient.RequestBodySpec)this.webTestClient.post().uri("/todos", new Object[0])).bodyValue(todo).exchange().expectStatus().isOk().expectBody().jsonPath("$").isArray().jsonPath("$.length()").isEqualTo(1).jsonPath("$[0].nome").isEqualTo(todo.getNome()).jsonPath("$[0].descricao").isEqualTo(todo.getDescricao()).jsonPath("$[0].realizada").isEqualTo(todo.isRealizada()).jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
   }

   @Test
   void testCreateTodoFailure() {
      ((WebTestClient.RequestBodySpec)this.webTestClient.post().uri("/todos", new Object[0])).bodyValue(new Todo("", "", false, 0)).exchange().expectStatus().isBadRequest();
   }
}

