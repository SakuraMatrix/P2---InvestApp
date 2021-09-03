package karate.rest.create;

import com.intuit.karate.junit5.Karate;

public class CreateRunner {

  @Karate.Test
  Karate runCreate() {
    return Karate.run().relativeTo(getClass());
  }
}