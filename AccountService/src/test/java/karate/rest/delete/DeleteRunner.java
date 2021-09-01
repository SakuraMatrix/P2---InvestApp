package karate.rest.delete;

import com.intuit.karate.junit5.Karate;

public class DeleteRunner {

  @Karate.Test
  Karate runDelete() {
    return Karate.run().relativeTo(getClass());
  }
}
