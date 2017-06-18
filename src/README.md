# program-replacer

A small Java program to demonstrate that you can overwrite a program while it is
currently running.

## Setup

1. Verify that `/usr/local/bin` is on your `$PATH`.
1. Have [Boot](http://boot-clj.com) installed.
1. Clone this repo.
1. Run `boot build` to build the replacer program.

This creates a jar file in the `target` directory.

## Demo

1. Run `java -jar target/replacer.jar` to create
   `/usr/local/bin/replaceme1234567890` for the first time.

1. Run `/usr/local/bin/replaceme1234567890`. It will print the same randomly
   generated UUID in a loop.

   > NOTE: This UUID is hard-coded into the program -- it is the same every time
   > you run that version of the program.

1. Keep that running.

   While it's running, run `java -jar target/replacer.jar` again.

1. The same UUID should keep printing until you stop the program via Ctrl-C.

1. When you run it again, you can see that the program has been replaced by a
   new program with a new UUID.
