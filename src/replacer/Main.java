package replacer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Main {
  private static final String BIN_PATH = "/usr/local/bin";
  private static final String PROGRAM = "replaceme1234567890";
  private static final String PROGRAM_PATH = BIN_PATH + "/" + PROGRAM;

  // Generates a little bash program that runs forever and prints a random UUID.
  private static List<String> generateProgram() {
    String uuid = UUID.randomUUID().toString();

    return Arrays.asList(
      "#!/bin/bash",
      "",
      "while true; do",
      "  echo " + uuid,
      "  sleep 1",
      "done"
    );
  }

  // Replaces /usr/local/bin/replaceme1234567890 with a new version that has a
  // different UUID.
  //
  // This works even if the program is currently running. When you restart the
  // program, its contents are new.
  public static void main(String[] argv) throws IOException {
    System.out.println("Replacing " + PROGRAM_PATH + "...");
    Path file = Paths.get(PROGRAM_PATH);
    Files.write(file, generateProgram());
    new File(PROGRAM_PATH).setExecutable(true);
    System.out.println("Done.");
  }
}
