# simple-jpa-app

A simple command-line app using JPA and Hibernate.

Compile with `mvn package`.

Run it within an IDE that runs the App class's main or using `mvn exec:java -Dexec.mainClass=de.iubh.webanwendungen.attempts.App`.

* First run: `Populating` should appear, input a word. The word is inserted in the database.
* Now comment out the property `javax.persistence.schema-generation.database.action` in the file `target/classes/META-INF/persistence.xml`
* Second run (do not recompile before!): The content of the DB should just be printed.
