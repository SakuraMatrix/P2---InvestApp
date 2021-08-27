package karate.rest.update;

import com.intuit.karate.junit5.Karate;

public class UpdateRunner {
  @Karate.Test
  Karate runUpdate() {
    return Karate.run().relativeTo(getClass());
  }
}
