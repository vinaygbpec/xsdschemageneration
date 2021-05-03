Steps to create jar of Amadesus classes for a new functionality.
1. Make a copy of 'S4HANA-SCHEMAS' module and give it a name specific to your functionality. For example let's name it 'S4HANA-SCHEMAS-DP'
2. In above created 'S4HANA-SCHEMAS-DP' module's resource folder copy your xsd and make its entry in 'oup-s4hana-bindings.xjb' and remove all other xsd's.
3. Update the 'S4HANA-SCHEMAS-DP' module's pom.xml's artifactId as per your functionality.
4. In outermost pom.xml add your new module.
5. Build the code with the command 'mvn clean install -Djavax.xml.accessExternalSchema=all'