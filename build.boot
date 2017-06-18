(set-env!
  :source-paths #{"src"}
  :dependencies '[[alandipert/boot-trinkets "2.0.0" :scope "test"]])

(task-options!
  pom {:project 'io.djy/program-replacer
       :version "0.0.1"
       :description "Small Java program that replaces an executable on $PATH."
       :url "https://github.com/daveyarwood/program-replacer"
       :scm {:url "https://github.com/daveyarwood/program-replacer"}
       :license {"name" "Eclipse Public License"
                 "url" "http://www.eclipse.org/legal/epl-v10.html"}}
  jar {:file "replacer.jar"
       :main 'replacer.Main}
  target {:dir #{"target"}})

(require '[alandipert.boot-trinkets :refer (run)])

(deftask build
  "Build the jar file."
  []
  (comp (javac) (pom) (jar) (target)))
